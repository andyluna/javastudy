package com.liyi.study.jdbc.day0429.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/27 21:24  星期二
 */
public class JDBCUtils {

    private static Properties prop = null;
    static {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        try {
            prop = new Properties();
            prop.load(is);
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    /**
     * 使用c3p0获取数据库连接
     * @return
     * @throws Exception
     */
       private static ComboPooledDataSource cpds=new ComboPooledDataSource("helloC3P0");
    public static Connection getconnection1() throws SQLException{
        Connection con = cpds.getConnection();

        return con;
    }



    /**
     * 关闭链接和Statement
     * @param connection
     * @param ps
     */
    public static void closeResource(Connection connection, Statement ps){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 关闭连接connection、ps和Statement
     * @param connection
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection connection, Statement ps, ResultSet rs){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
