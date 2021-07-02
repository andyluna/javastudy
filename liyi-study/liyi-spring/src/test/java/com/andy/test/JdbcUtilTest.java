package com.andy.test;

import com.liyi.spring.spring5.aop.User;
import com.liyi.spring.spring5.jdbc.JDBCUtils;
import com.liyi.spring.spring5.jdbc.JDBCUtils2;
import com.liyi.spring.spring5.jdbc.JDBCUtils3;
import com.liyi.spring.spring5.jdbc.JDBCUtils4;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @time: 2021/7/2 七月 15:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class JdbcUtilTest {
    @Test
    public void test1() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc1.xml");
        JDBCUtils jdbcUtils = context.getBean("jDBCUtils", JDBCUtils.class);
        System.out.println(jdbcUtils);
        Connection connection = jdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test2() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc2.xml");
        JDBCUtils2 jdbcUtils2 = context.getBean("jDBCUtils2", JDBCUtils2.class);
        System.out.println(jdbcUtils2);
        Connection connection = jdbcUtils2.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test3() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc3.xml");
        JDBCUtils3 jdbcUtils3 = context.getBean("jDBCUtils3", JDBCUtils3.class);
        System.out.println(jdbcUtils3);
        Connection connection = jdbcUtils3.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test3_1() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc3-1.xml");
        JDBCUtils3 jdbcUtils3 = context.getBean("jDBCUtils3", JDBCUtils3.class);
        System.out.println(jdbcUtils3);
        Connection connection = jdbcUtils3.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test4() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4.xml");
        JDBCUtils4 jdbcUtils4 = context.getBean("jDBCUtils4", JDBCUtils4.class);
        System.out.println(jdbcUtils4);
        Connection connection = jdbcUtils4.getConnection();
        System.out.println(connection);
        //这里 还可以直接拿到 druid 数据源
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println("这里的 dataSource = "+dataSource);
    }
}
