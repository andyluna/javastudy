package com.study.cms.manager.dao.impl.hibernate;

import com.alibaba.druid.sql.dialect.ads.visitor.AdsOutputVisitor;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 22:00  星期三
 */
public class UserDaoHibernateImplTest {
    private UserDao userDao = new UserDaoHibernateImpl();
    @Test
    public void queryByUsername() {
        User user = userDao.queryByUsername("andy8");
        System.out.println(user);
    }
    @Test
    public void queryByUsername1() {
        User user = userDao.queryByUsername(514,"andy7");
        System.out.println(user);
    }


    @Test
    public void queryByUsernameAndPassword() {
        User user = userDao.queryByUsernameAndPassword("andy8","andy8");
        System.out.println(user);

    }

    @Test
    public void queryUserById() {

        User user = userDao.queryUserById(547);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("liyi2021");
        user.setPassword("liyi2021");
        user.setPhone("12345646");
        user.setName("李逸2021");
        user.setAddress("长沙天心区");
        user.setSex(1);
        user.setDept_id(1);

        System.out.println("执行之前"+user);

        userDao.addUser(user);

        System.out.println("执行之后"+user);

    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1531);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1533);
        user.setUsername("liyi20211");
        user.setPassword("liyi20211");
        user.setPhone("123456461");
        user.setName("李逸20211");
        user.setAddress("长沙天心区11");
        user.setSex(1);
        user.setDept_id(1);
        userDao.updateUser(user);
        User u1 = userDao.queryByUsername("liyi20211");
        System.out.println(u1);


    }

    @Test
    public void queryUsers() {
       List<User> users = userDao.queryUsers("andy", "爱迪", 1,1,20);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUsersTotal() {

        int i = userDao.queryUsersTotal("andy", "爱迪", 1);
        System.out.println(i);
    }
}