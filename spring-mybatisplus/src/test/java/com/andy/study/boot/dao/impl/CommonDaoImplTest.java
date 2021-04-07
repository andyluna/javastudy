package com.andy.study.boot.dao.impl;

import com.andy.study.boot.MyBatisPlusApplicationTest;
import com.andy.study.boot.dao.CommonDao;
import com.andy.study.boot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @time: 2021/1/20 一月 15:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CommonDaoImplTest extends MyBatisPlusApplicationTest {

    @Autowired
    private CommonDao commonDao;

    @Test
    public void test1(){
        System.out.println("commonDao"+commonDao);
        String sql = "select ID,name,age,email from user where id=? and name=?";
        //2 Jack
        Map<String, Object> map = commonDao.selectOne(sql, 2, "Jack");
        System.out.println(map);
    }


    @Test
    public void test2(){
        System.out.println("commonDao"+commonDao);
        String sql = "select id,NAME,age,email from user where id=? and name=?";
        //2 Jack
        User user = commonDao.selectOne(sql, User.class,2, "Jack");
        System.out.println(user);
    }


    @Test
    public void testList1(){
        String sql = "select id,NAME,age,email from user where id>?";
        //2 Jack
        List<User> user = commonDao.selectList(sql, User.class,2);
        System.out.println(user);
    }


    @Test
    public void testList2(){
        String sql = "select id,NAME,age,email from user where id>?";
        //2 Jack
        List<Map<String,Object>> list = commonDao.selectList(sql,2);
        System.out.println(list);
    }

    @Test
    public void testSelectOne(){
        System.out.println("commonDao"+commonDao);
        String sql = "select ID,name,age,email from user where id=:id and name=:name";
        Map<String,Object> map = new HashMap<>();
        map.put("id",3);
        map.put("name","Jack");
        Map<String, Object> res = commonDao.selectOne(sql, map);
        System.out.println(res);

        User u1= commonDao.selectOne(sql,User.class, map);
        System.out.println(u1);
    }


    @Test
    public void testSelectList(){
        System.out.println("commonDao"+commonDao);
        String sql = "select ID,name,age,email from user where id>:id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        List<Map<String,Object>> res = commonDao.selectList(sql, map);
        System.out.println(res);

        List<User> u1= commonDao.selectList(sql,User.class, map);
        System.out.println(u1);
    }

}