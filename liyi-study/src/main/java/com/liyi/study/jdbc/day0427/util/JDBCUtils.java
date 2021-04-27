package com.liyi.study.jdbc.day0427.util;

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


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Connection connection = getConnection();

            System.out.println(connection);
        }

    }


    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() {
        //读取配置文件中的4个基本信息
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverClass = prop.getProperty("driverClass");
        //加载驱动
        try {
            Class.forName(driverClass);
            return  DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
