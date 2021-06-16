package com.study.cms.comm.dao;

import com.study.cms.comm.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 18:33  星期三
 */
public abstract class BaseDao {

    //使用Dbutils操作数据库
    private static QueryRunner queryRunner=new QueryRunner();


    /**
     * 执行 新增/修改/删除的SQL语句
     * @param sql
     * @param args
     * @return
     */
    public static int update(String sql, Object...args){
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
     * 执行查询返回一个JavaBean对象的SQL语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T queryJavaBean(Class<T> type,String sql,Object...args){
        Connection con = JDBCUtils.getCon();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeCon(con);
        }
        return null;
    }


    /**
     * 执行查询返回多个JavaBean对象的SQL语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> queryJavaBeanList(Class<T> type, String sql, Object... args) {
        Connection con = JDBCUtils.getCon();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeCon(con);
        }
        return null;
    }



}
