package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 22:38  星期二
 */
public class CommonDaoHibernateImplTest {

    private CommonDaoEnhance commonDaoEnhance;
    @Before
    public void before(){
        commonDaoEnhance = new CommonDaoHibernateImpl();
    }

    @After
    public void destory(){
        commonDaoEnhance = null;
    }
    @Test
    public void test1(){
        User u = new User();
        u.setUsername("zhangsan1");
        u.setPassword("1231");
        u.setPhone("13875125522");
        u.setName("张三");
        u.setAddress("长沙");
        u.setSex(1);
        u.setDept_id(1);

        commonDaoEnhance.insert(u);
    }



    @Test
    public  void test2(){
        User u = new User();
        u.setUsername("andy4");
        List<Object> objects = commonDaoEnhance.selectList(u);
        objects.forEach(System.out::println);
    }


    @Test
    public  void test3(){
        User u = new User();
        u.setUsername("andy4");
        PageRes res = commonDaoEnhance.selectPage(u,1,10);
        System.out.println(res);
        res.getData().forEach(System.out::println);
    }
}