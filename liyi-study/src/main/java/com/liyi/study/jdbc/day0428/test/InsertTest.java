package com.liyi.study.jdbc.day0428.test;

import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 18:54  星期三
 */
public class InsertTest {

    //批量插入数据的操作,使用PreparedStatement
    public void testInsert1(){
        Connection con= null;
        PreparedStatement ps= null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();
            String sql="insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i=1;i<20000;i++){
                ps.setObject(1,"name_"+i);

                ps.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("花费时间为："+(end-start));   //花费时间为：51717

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps);

        }
    }




    @Test
    public void testInsert2(){
        Connection con= null;
        PreparedStatement ps= null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();
            String sql="insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i=1;i<1000000;i++){
                ps.setObject(1,"name_"+i);

                //"攒"sql
                ps.addBatch();

                if (i%500==0){
                    //执行batch
                    ps.executeBatch();
                    //清空batch
                    ps.clearBatch();
                }

            }

            long end = System.currentTimeMillis();
            System.out.println("花费时间为："+(end-start));   //花费时间为：49273

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps);

        }
    }


    @Test
    public void testInsert3(){
        Connection con= null;
        PreparedStatement ps= null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();

            //设置不允许自动提交数据
            con.setAutoCommit(false);

            String sql="insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i=1;i<1000000;i++){
                ps.setObject(1,"name_"+i);

                //"攒"sql
                ps.addBatch();

                if (i%500==0){
                    //执行batch
                    ps.executeBatch();
                    //清空batch
                    ps.clearBatch();
                }

            }

            //提交数据
            con.commit();

            long end = System.currentTimeMillis();
            System.out.println("花费时间为："+(end-start));   //花费时间为：
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps);

        }
    }









}
