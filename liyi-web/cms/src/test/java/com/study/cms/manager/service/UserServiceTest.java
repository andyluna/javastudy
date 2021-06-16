//package com.study.cms.manager.service;
//
//import com.study.cms.manager.entity.User;
//import com.study.cms.manager.service.impl.UserServiceImpl;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/6/16 21:07  星期三
// */
//public class UserServiceTest {
//
//    UserService userService=new UserServiceImpl();
//
//    @Test
//    public void register() {
//        userService.register(new User(null,"liting","123","15575108840"));
//    }
//
//    @Test
//    public void login() {
//        userService.login(new User(null,"admin","123",null));
//    }
//
//    @Test
//    public void checkUsername() {
//        boolean admin = userService.checkUsername("admin");
//        if (admin){
//            System.out.println("用户名已经存在!");
//        }else {
//            System.out.println("用户名可用.");
//        }
//    }
//}