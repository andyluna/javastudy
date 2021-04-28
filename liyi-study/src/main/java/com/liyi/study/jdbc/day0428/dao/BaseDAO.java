package com.liyi.study.jdbc.day0428.dao;

import com.liyi.study.jdbc.day0427.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 22:43  星期三
 */
public abstract class BaseDAO {


    //通用的增删改操作（考虑事务）
    public int update(Connection con,String sql,Object...args){
        PreparedStatement ps=null;

        try {
            //预编译sql语句，返回ps的实例
            ps=con.prepareStatement(sql);
            //填充占位符
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //执行
            return ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }




    //通用的查询操作，用于返回数据库表中的一条数据(考虑事务)
    public <T> T getInstance(Connection con,Class<T> clazz,String sql,Object... args){

        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);

            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                T t=clazz.newInstance();
                for (int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);

                }
                return t;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;

    }


    //通用的查询操作，用于返回数据库表中的多条数据构成的集合(考虑事务)
    public <T> List<T> getForList(Connection con,Class<T> clazz, String sql, Object... args){

        PreparedStatement ps= null;
        ResultSet rs = null;
        try {

            ps = con.prepareStatement(sql);

            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //创建集合对象
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()){
                T t=clazz.newInstance();

                //处理每一行数据中的每一个列：给t对象指定的属性赋值
                for (int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);

                }
                list.add(t);

            }
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }


    //用于查询特殊值的通用方法
    public <E> E getValue(Connection con,String sql,Object...args)  {
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            ps = con.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;

    }





}
