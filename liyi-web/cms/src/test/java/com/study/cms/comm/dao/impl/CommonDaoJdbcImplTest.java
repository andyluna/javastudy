package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.manager.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 0:08  星期二
 */
public class CommonDaoJdbcImplTest {

    private CommonDao commonDao = null;

    @Before
    public void before(){
        commonDao = new CommonDaoJdbcImpl();
        System.out.println("执行之前");
    }

    @Test
    public void update() {
        String sql = "update c_menu set name =? ,url = ? , open_type=?,last_update_date=? where id = ?";
        commonDao.update(sql,"菜单1","http://www.baidu.com","当前页",new Date(),2);

    }


    @Test
    public void selectOne() {
        String sql = "select id,username,password,name,phone,address,sex,dept_id from c_user where id = ?";
        User user = commonDao.selectOne(sql, User.class, 2);
        System.out.println(user);


        String sql1 = "select username from c_user where id = ?";
        String username = commonDao.selectOne(sql1, String.class, 2);
        System.out.println(username);


        String sql2 = "select create_date from c_dept where id = ?";
        Date date = commonDao.selectOne(sql2, Date.class, 1);
        System.out.println(date);


        String sql3 = "select count(*)  from c_dept  ";
        Integer total = commonDao.selectOne(sql3, Integer.class);
        System.out.println(total);

    }

    @Test
    public void test1(){
        Class stringClass=String.class;
        System.out.println("String is primitive type："+stringClass.isPrimitive());

        Class booleanClass=Boolean.class;
        System.out.println("Boolean is primitive type："+booleanClass.isPrimitive()+booleanClass);

        Class booleanType=boolean.class;
        System.out.println("boolean is primitive type："+booleanType.isPrimitive()+booleanType);

        Class byteType=byte.class;
        System.out.println("byte is primitive type："+byteType.isPrimitive());

        Class charType=char.class;
        System.out.println("char is primitive type："+charType.isPrimitive());

        Class shortType=short.class;
        System.out.println("short is primitive type："+shortType.isPrimitive());

        Class intType=int.class;
        System.out.println("int is primitive type："+intType.isPrimitive());

        Class longType=long.class;
        System.out.println("long is primitive type："+longType.isPrimitive());

        Class floatType=float.class;
        System.out.println("float is primitive type："+floatType.isPrimitive());

        Class doubleType=double.class;
        System.out.println("double is primitive type："+doubleType.isPrimitive());
    }

    @After
    public void after(){
        commonDao =null;
        System.out.println("执行之后");
    }
}