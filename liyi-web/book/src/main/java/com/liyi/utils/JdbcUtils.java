package com.liyi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/16 18:27  星期日
 */
public class JdbcUtils {


    private static DruidDataSource dataSource;

    static {
        try {
        Properties properties=new Properties();
        //
        JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //创建数据库连接池
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("?");
    }

    /**
     * 获取数据库连接池中的连接
     * @return
     */
    public static Connection getCon(){
        return null;
    }

    /**
     * 关闭连接,放回数据库连接池
     * @param con
     */
    public static void closeCon(Connection con){

    }
}
