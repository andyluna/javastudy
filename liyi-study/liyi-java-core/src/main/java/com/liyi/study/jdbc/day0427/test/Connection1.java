package com.liyi.study.jdbc.day0427.test;//package com.liyi.study.jdbc.day0427.test;
//
//import org.junit.Test;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/4/27 18:44  星期二
// */
//public class Connection1 {
////
////    @Test
////    public void testConnection1() throws SQLException{
////        Driver driver=new com.mysql.cj.jdbc.Driver();
////        String url="jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
////        //将用户名密码封装在Properties中
////        Properties info=new Properties();
////        info.setProperty("user","liyi");
////       info.setProperty("password","liyi");
////
////        Connection con=driver.connect(url, info);
////        System.out.println(con);
////
////    }
//
//    @Test
//    public void testConnection2() throws Exception{
//        //使用反射获取Driver实现对象
//        Class clazz=Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver= (Driver) clazz.newInstance();
//
//        //提供要连接的数据库
//        String url="jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
//
//        //提供连接要用的用户名密码
//        Properties info=new Properties();
//        info.setProperty("user","liyi");
//        info.setProperty("password","liyi");
//
//        //获取连接
//        Connection connect = driver.connect(url, info);
//        System.out.println(connect);
//    }
//
//
//    @Test
//    public void testConnection3() throws Exception{
//        //提供另外三个连接
//        String url="jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
//        String user="liyi";
//        String password="liyi";
//
//        //获取Driver实现类的对象
//        Class clazz=Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver= (Driver) clazz.newInstance();
//
//
//
//        //注册驱动
//        DriverManager.registerDriver(driver);
//
//
//        //获取连接
//        Connection con=DriverManager.getConnection(url,user,password);
//
//        System.out.println(con);
//    }
//
//
//    @Test
//    public void testConnection4() throws Exception{
//        //提供另外三个连接
//        String url="jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
//        String user="liyi";
//        String password="liyi";
//
//        //加载Driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
////        Driver driver= (Driver) clazz.newInstance();
//
//
//
//        //注册驱动
////        DriverManager.registerDriver(driver);
//
//
//        //获取连接
//        Connection con=DriverManager.getConnection(url,user,password);
//
//        System.out.println(con);
//    }
//
//
//    //将数据库连接需要的四个基本信息声明配置文件中，通过读取配置文件的方式，获取连接
//    @Test
//    public void getConnection5() throws Exception{
//        //读取配置文件中的4个基本信息
//        InputStream is = Connection1.class.getClassLoader().getResourceAsStream("/jdbc.properties");
//
//        Properties pros=new Properties();
//        pros.load(is);
//
//        String user=pros.getProperty("user");
//        String password=pros.getProperty("password");
//        String url=pros.getProperty("url");
//        String driverClass=pros.getProperty("driverClass");
//
//        //加载驱动
//        Class.forName(driverClass);
//
//        //获取连接
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//
//
//    }
//
//
//
//}
