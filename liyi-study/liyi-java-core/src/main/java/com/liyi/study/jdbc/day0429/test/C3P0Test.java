package com.liyi.study.jdbc.day0429.test;//package com.liyi.study.jdbc.day0429.test;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.junit.Test;
//
//import java.sql.Connection;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/4/29 20:59  星期四
// */
//public class C3P0Test {
//
//    @Test
//    public void testGetConnection() throws Exception{
//        //获取c3p0数据库连接池
//        ComboPooledDataSource cpds=new ComboPooledDataSource();
//        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true");
//        cpds.setUser("liyi");
//        cpds.setPassword("liyi");
//
//        //通过设置相关的参数，对数据库连接池进行管理
//        //设置初始时数据库连接池中的连接数
//        cpds.setInitialPoolSize(10);
//
//        Connection con=cpds.getConnection();
//        System.out.println(con);
//
//    }
//
//    //使用配置文件
//    @Test
//    public void testGetConnection1() throws Exception{
//        ComboPooledDataSource cpds=new ComboPooledDataSource("helloC3P0");
//        Connection con = cpds.getConnection();
//        System.out.println(con);
//
//    }
//
//
//}
