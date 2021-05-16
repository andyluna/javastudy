package com.liyi.dao.impl;

import com.liyi.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/16 22:31  星期日
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * 用来执行Insert/Update/Delete语句
     * @return
     */
    public int update(String sql,Object...args){
        Connection con= JDBCUtils.getCon();
        try {
           return queryRunner.update(con,sql,args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeCon(con);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的Sql语句
     * @param args Sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection con=JDBCUtils.getCon();
        try {
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeCon(con);
        }
        return null;
    }


    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的Sql语句
     * @param args Sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection con=JDBCUtils.getCon();
        try {
            return queryRunner.query(con,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeCon(con);
        }
        return null;
    }


    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingValue(String sql,Object...args){
        Connection con=JDBCUtils.getCon();
        try {
            return queryRunner.query(con,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeCon(con);
        }
        return null;
    }

}
