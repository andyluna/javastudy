package com.andy.study.boot.dao.impl;

import com.andy.study.boot.MyBatisPlusApplicationTest;
import com.andy.study.boot.dao.CommonDao;
import com.andy.study.boot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @time: 2021/1/20 一月 15:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class JdbcTemplateTest extends MyBatisPlusApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void test1(){
        String sql = "select count(*)  from (select ID,name,age,email from user where id>? order by age desc ) cot_";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, 1);
        System.out.println(integer);


    }

    @Test
    public void test2(){
        String sql = "select count(*)  from (select ID,name,age,email from user where id>:id) cot_";
        Map<String,Object> param = new HashMap<>();
        param.put("id", 3);
        Integer integer = namedParameterJdbcTemplate.queryForObject(sql, param, Integer.class);
        System.out.println(integer);
    }
    @Autowired
    private DataSource dataSource;
    @Test
    public void test3() throws SQLException {
        DatabaseMetaData md=jdbcTemplate.getDataSource().getConnection().getMetaData();
        System.out.println(md.getDatabaseProductName());
        System.out.println(md.getDatabaseProductVersion());

        DatabaseDriver.fromProductName(md.getDatabaseProductName());
    }

    @Test
    public void test4(){
        StringBuffer sb = new StringBuffer("");
        System.out.println(sb);
        sb.delete(0,sb.length());
        sb.append("asdasdsa");
        System.out.println(sb);
    }
}