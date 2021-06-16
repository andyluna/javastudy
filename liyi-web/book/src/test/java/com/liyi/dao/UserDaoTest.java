package com.liyi.dao;

import com.liyi.dao.UserDao;
import com.liyi.dao.impl.UserDaoImpl;
import com.liyi.pojo.User;
import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/16 23:58  星期日
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUserName(){

        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在!");
        }


    }

    @Test
    public void queryUSerByUsernameAndPassWord(){
        if(userDao.queryUserByUsernameAndPassword("admin","123")==null){
            System.out.println("用户名或密码错误，登录失败！");
        }else{
            System.out.println("查询成功!");
        }

    }

    @Test
    public void savaUser(){
        System.out.println(userDao.savaUser(new User(null,"zhuyi11","111222","3366@qq.com")));

    }
}
