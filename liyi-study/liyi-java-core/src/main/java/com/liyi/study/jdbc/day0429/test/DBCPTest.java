package com.liyi.study.jdbc.day0429.test;//package com.liyi.study.jdbc.day0429.test;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp.BasicDataSourceFactory;
//import org.junit.Test;
//
//import javax.sql.DataSource;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/4/29 23:03  星期四
// */
//public class DBCPTest {
//
//    @Test
//    public void testGetConnection() throws SQLException{
//        //创建DBCP的数据库连接池
//        BasicDataSource source=new BasicDataSource();
//        //设置基本信息
//        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        source.setUrl("jdbc:mysql://localhost:3306/liyi?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true");
//        source.setUsername("liyi");
//        source.setPassword("liyi");
//
//        Connection con=source.getConnection();
//        System.out.println(con);
//
//    }
//
//
//    @Test
//    public void testGetConnection1() throws Exception{
//        Properties pros=new Properties();
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//
//        pros.load(is);
//        DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
//        Connection con=dataSource.getConnection();
//        System.out.println(con);
//    }
//}
