package com.study.cms.manager.dao;

import com.study.cms.manager.dao.impl.jdbc.UserDaoImpl;
import com.study.cms.manager.entity.User;
import org.junit.Test;

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
        userDao.addUser(new User(null, "xiangdan", "123", "11112222333","爱迪","湖南长沙",1,1));
        System.out.println("新增成功");
    }

    @Test
    public void userList(){
        for (Object o : userDao.userList()) {
            System.out.println(o);
        }
    }

    @Test
    public void addUserList() {
        User user = null;
        for (int i = 0; i < 500; i++) {
            String username = "andy"+i;
            user = new User(null, username, username, "1238885234"+i,"爱迪"+i,"湖南长沙"+i,i%2,1);
            userDao.addUser(user);
        }


        System.out.println("新增成功");
    }



}