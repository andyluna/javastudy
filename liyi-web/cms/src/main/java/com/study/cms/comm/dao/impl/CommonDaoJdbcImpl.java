package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.comm.utils.JDBCUtils;
import com.study.cms.comm.vo.PageRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最原始的方式实现
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 0:01  星期二
 */
public class CommonDaoJdbcImpl implements CommonDao {
    public static final Logger log = LoggerFactory.getLogger(CommonDaoJdbcImpl.class);
    private static Map<Class<?>,Class<?>> map = null;
    static{
        map = new HashMap<>();
        map.put(boolean.class,Boolean.class);
        map.put(char.class,Character.class);
        map.put(byte.class,Byte.class);
        map.put(short.class,Short.class);
        map.put(int.class,Integer.class);
        map.put(long.class,Long.class);
        map.put(float.class,Float.class);
        map.put(double.class,Double.class);

        map.put(Boolean.class,Boolean.class);
        map.put(Character.class,Character.class);
        map.put(Byte.class,Byte.class);
        map.put(Short.class,Short.class);
        map.put(Integer.class,Integer.class);
        map.put(Long.class,Long.class);
        map.put(Float.class,Float.class);
        map.put(Double.class,Double.class);

        map.put(String.class,String.class);
        map.put(Date.class,Date.class);
        map.put(java.sql.Date.class,java.sql.Date.class);
        map.put(java.sql.Timestamp.class,java.sql.Timestamp.class);
    }

    @Override
    public int update(String sql, Object... param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;
        try{
            //1.获取连接
            conn = JDBCUtils.getCon();
            //2.创建执行器
            pstmt = conn.prepareStatement(sql);
            //3.设置参数
            if(param!=null && param.length>0){
                for (int i = 1; i <=param.length ; i++) {
                    pstmt.setObject(i,param[i-1]);
                }
            }
            //4.执行
            n = pstmt.executeUpdate();
            log.debug("执行update 成功");
        }catch (Exception e){
            log.error("执行update 方法出错了",e);
        }finally {
            JDBCUtils.close(conn,pstmt,null);
        }
        return n;
    }

    @Override
    public <T> PageRes selectPage(String sql, Class<T> returnType, Integer curPage, Integer pageSize, Object... param) {
        if(curPage==null || curPage<1){
            curPage = 1;
        }
        if(pageSize==null || pageSize<1){
            curPage = 20;
        }
        PageRes pageRes = new PageRes();
        pageRes.setCurPage(curPage);
        pageRes.setPageSize(pageSize);
        //1.根据sql语句 查询总数  sql   param
        // select id,username,password,name,phone,address,sex,dept_id from c_user where id>?
        sql = sql.trim();
        String slq3 = sql.toLowerCase();
        int from = slq3.indexOf("from");
        String totalSql = "select count(*) "+sql.substring(from);
        //2.查询总数
        Integer total = selectOne(totalSql, Integer.class, param);
        //3.设置总数和 总页数
        pageRes.setTotal(total);
        pageRes.setTotalPage(total%pageSize==0?total/pageSize:total/pageSize+1);
        //4.拼接分页sql
        sql+=" limit "+(curPage-1)*pageSize+","+pageSize;
        //5.查询分页的数据
        List<T> datas = selectList(sql, returnType, param);
        pageRes.setData(datas);
        return pageRes;
    }

    @Override
    public <T> List<T> selectList(String sql, Class<T> returnType, Object... param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> resList = new ArrayList<>();
        try{
            //1.获取连接
            conn = JDBCUtils.getCon();
            //2.创建执行器
            pstmt = conn.prepareStatement(sql);
            //3.设置参数
            if(param!=null && param.length>0){
                for (int i = 1; i <=param.length ; i++) {
                    pstmt.setObject(i,param[i-1]);
                }
            }
            //4.执行查询
            rs = pstmt.executeQuery();
            Class<?> aClass = map.get(returnType);
            while(rs.next()){
                T res = resovleResultSet(rs,returnType);
                resList.add(res);
            }
            log.debug("执行selectOne 成功");
        }catch (Exception e){
            log.error("执行selectOne 方法出错了",e);
        }finally {
            JDBCUtils.close(conn,pstmt,rs);
        }
        return resList;
    }


    @Override
    public <T> T selectOne(String sql, Class<T> returnType, Object... param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Object res = null;
        try{
            //1.获取连接
            conn = JDBCUtils.getCon();
            //2.创建执行器
            pstmt = conn.prepareStatement(sql);
            //3.设置参数
            if(param!=null && param.length>0){
                for (int i = 1; i <=param.length ; i++) {
                    pstmt.setObject(i,param[i-1]);
                }
            }
            //4.执行查询
            rs = pstmt.executeQuery();
            if(rs.next()){
                res = resovleResultSet(rs,returnType);
            }else{//没有查询到数据
                log.debug("暂时不考虑");
            }
            log.debug("执行selectOne 成功");
        }catch (Exception e){
            log.error("执行selectOne 方法出错了",e);
        }finally {
            JDBCUtils.close(conn,pstmt,rs);
        }
        return (T) res;
    }


    private <T> T resovleResultSet(ResultSet rs,Class<T> returnType) throws SQLException, InstantiationException, IllegalAccessException {
        Object res = null;
        if(map.containsKey(returnType)){
            Class<?> aClass = map.get(returnType);
            if(aClass==Boolean.class){
                res = rs.getBoolean(1);
            }else if(aClass==Character.class){
                String tmp= rs.getString(1);
                res = tmp==null?null:tmp.charAt(00);
            }else if(aClass==Byte.class){
                //res = rs.getInt(1);
            }else if(aClass==Short.class){
                res = rs.getShort(1);
            }else if(aClass==Integer.class){
                res = rs.getInt(1);
            }else if(aClass==Long.class){
                res = rs.getLong(1);
            }else if(aClass==Float.class){
                res = rs.getFloat(1);
            }else if(aClass==Double.class){
                res = rs.getDouble(1);
            }else if(aClass==String.class){
                res = rs.getString(1);
            }else if(aClass==Date.class){
                res = rs.getDate(1);
            }else if(aClass==java.sql.Date.class){
                res = rs.getDate(1);
            }else if(aClass== Timestamp.class){
                res = rs.getTimestamp(1);
            }

        }else{//是一个具体的java类
            res = returnType.newInstance();
            Field[] fields = returnType.getDeclaredFields();
            for(Field f :fields){
                String columnName = f.getName();
                Class<?> type = f.getType();
                Object value = null;
                try {
                    value = rs.getObject(columnName,type);
                }catch (Exception e){
                    log.warn("字段:{} 在查询语句中不存在",columnName);
                    continue;
                }

                String methodName ="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);//得到一个属性对应的set 方法名
                try {
                    Method m = returnType.getMethod(methodName,type);
                    m.setAccessible(true);
                    m.invoke(res, value);
                }catch (Exception e){
                    log.error("调用方法{}出错:{}",methodName,e.getMessage());
                    f.setAccessible(true);
                    try {
                        f.set(res, value);
                    }catch (Exception e1){
                        log.error("给字段[{}]赋值时出错了",e1);
                    }
                }
            }
        }

        return (T)res;
    }




}
