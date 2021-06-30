package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 19:58  星期三
 */
public class UserDaoMyBatisImplTest {

    UserDao userDao=new UserDaoMyBatisImpl();
    @Test
    public void queryByUsername() {
        User admin = userDao.queryByUsername("admin");
        System.out.println(admin);

    }

    @Test
    public void testQueryByUsername() {
        User admin = userDao.queryByUsername(1, "admin");
        System.out.println(admin);
    }

    @Test
    public void queryByUsernameAndPassword() {
        User admin = userDao.queryByUsernameAndPassword("admin", "123");
        System.out.println(admin);
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(2);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        userDao.addUser(new User(null,"liyi0009","123","18818818812","李逸","长沙",1,1));
        System.out.println("添加成功");

    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(507);
        System.out.println("删除成功");
    }

    @Test
    public void updateUser() {
        userDao.updateUser(new User(508,"liyi508","123","18818818812","李逸","长沙",1,1));
        System.out.println("修改成功");

    }

    @Test
    public void queryUsers() {
        List<User> userList = userDao.queryUsers("andy", "andy", null, 1, 20);
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void queryUsersTotal() {
        int i = userDao.queryUsersTotal("andy", "andy", null);
        System.out.println("查到"+i+"条记录");

    }
}