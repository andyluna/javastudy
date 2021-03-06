package com.study.cms.comm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 17:27  星期三
 */
public class JDBCUtils {
    private static DruidDataSource dataSource;


    //静态代码块
    static {
        InputStream inputStream = null;
        try {
            Properties properties = new Properties();
            //读取配置文件
            inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getCon(){
        Connection con=null;

        try {
            con=dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


    /**
     * 关闭数据库连接
     * @param con
     */
    public static void closeCon(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭方法
     * @param con
     * @param stmt
     * @param resultSet
     */
    public static void close(Connection con, Statement stmt, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con !=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }




}
