package com.liyi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/16 18:27  星期日
 */
public class JDBCUtils {


    private static DruidDataSource dataSource;

    private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();

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


    public static void main(String[] args) throws Exception {
        System.out.println(getCon());
    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null, 说明获取连接失败
     */
    public static Connection getCon() {
        Connection con=conns.get();

        if (con==null){
            try {
                //从数据库连接池中获取连接
                con=dataSource.getConnection();

                //保存到ThreadLocal对象中，供后面的jdbc操作使用
                conns.set(con);

                //设置为手动管理事务
                con.setAutoCommit(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        //如果不等于null,说明之前使用过连接操作数据库
        if (connection!=null){
            try {
                //提交事务
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //关闭链接，释放资源
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }


    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        //如果不等于null,说明之前使用过连接操作数据库
        if (connection!=null){
            try {
                //回滚事务
                connection.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //关闭链接，释放资源
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，因为Tomcat服务器底层使用了线程池技术
        conns.remove();

    }







    /**
     * 关闭连接,放回数据库连接池
     *
     * @param con
     */
//    public static void closeCon(Connection con) {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
