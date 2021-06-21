package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.comm.utils.JDBCUtils;
import com.study.cms.comm.vo.PageRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * 最原始的方式实现
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 0:01  星期二
 */
public class CommonDaoJdbcImpl implements CommonDao {
    public static final Logger log = LoggerFactory.getLogger(CommonDaoJdbcImpl.class);
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
        return null;
    }

    @Override
    public <T> List<T> selectList(String sql, Class<T> returnType, Object... param) {
        return null;
    }

    @Override
    public <T> T selectOne(String sql, Class<T> returnType, Object... param) {
        return null;
    }
}
