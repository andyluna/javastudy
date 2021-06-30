package com.study.cms.manager.service.impl;

import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;
import org.junit.Test;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/17 22:06  星期四
 */
public class UserServiceImplTest {

    UserService userService=new UserServiceImpl();


    @Test
    public void addUser(){
        userService.addUser(new User(null,"LiYi05","123","12345678911","李逸","湖南常德",1,0));
        System.out.println("新增成功");
    }

    @Test
    public void queryUserByUserNameTest(){
        boolean admin = userService.existUserByUserName("999");
        System.out.println(admin);
    }
}