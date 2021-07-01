package com.liyi.spring.spring5.service;

import com.liyi.spring.spring5.User;
import com.liyi.spring.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 16:44  星期四
 */
@Service(value = "userService")
public class UserService {

    @Value(value = "张三")
    private String name;

    //@Autowired  //根据类型注入
    //@Qualifier(value = "userDaoImpl1")  //根据名称注入
    @Resource(name = "userDaoImpl1")
    private UserDao userDao;

    public void add(){
        System.out.println("Service add......."+name);
        userDao.update();
    }


//    public void setUserDao(UserDao userDao){
//        this.userDao=userDao;
//    }




}
