package com.andy.test;

import com.liyi.spring.spring5.aop.User;
import com.liyi.spring.spring5.jdbc.JDBCUtils;
import com.liyi.spring.spring5.jdbc.JDBCUtils2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
