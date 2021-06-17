package com.study.cms.manager.service.impl;

import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/17 22:06  星期四
 */
public class UserServiceImplTest {

    UserService userService=new UserServiceImpl();
    @Test
    public void queryUsers() {
        List<User> users = userService.queryUsers();
        System.out.println(users);
    }
}