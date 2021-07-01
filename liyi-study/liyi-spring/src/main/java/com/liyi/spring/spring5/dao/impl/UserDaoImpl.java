package com.liyi.spring.spring5.dao.impl;

import com.liyi.spring.spring5.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 16:45  星期四
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {

    @Override
    public void update() {
        System.out.println("dao update......");
    }
}
