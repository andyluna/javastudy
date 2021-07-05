package com.liyi.spring.spring5.xmlanno.dao.impl;

import com.liyi.spring.spring5.xmlanno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 16:19  星期一
 */
@Repository
public class AccountImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void reduceMoney() {
        String sql="update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    @Override
    public void addMoney() {
        String sql="update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }
}
