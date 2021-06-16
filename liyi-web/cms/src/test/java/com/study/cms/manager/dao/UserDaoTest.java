package com.study.cms.manager.dao;

import com.study.cms.manager.dao.impl.UserDaoImpl;
import com.study.cms.manager.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 21:12  星期三
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();

    @Test
    public void queryByUsername() {
        if (userDao.queryByUsername("admin")==null){
            System.out.println("已存在");
        }else {
            System.out.println("可用");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        User admin = userDao.queryByUsernameAndPassword("admin", "123");

        if (admin==null){
            System.out.println("用户名或密码错误!");
        }else {
            System.out.println("登录成功!");
        }
    }

    @Test
    public void addUser() {
        userDao.addUser(new User(null, "xiangdan", "123", "11112222333"));
        System.out.println("新增成功");
    }
}