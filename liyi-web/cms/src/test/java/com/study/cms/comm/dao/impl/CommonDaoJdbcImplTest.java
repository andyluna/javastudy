package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

//        String sql2="insert into c_menu(name,url,open_type,parent_id,create_date,last_update_date)values(?,?,?,?,?,?)";
//        commonDao.update(sql2,"菜单2","http://www.baidu.com","当前页",001,new Date(),new Date());

    }


    @Test
    public void selectOne1() {
        String sql = "select id,username,password,name,phone,address,sex,dept_id from c_user where id = ? and sex=?";
        User user = commonDao.selectOne(sql, User.class, 2,1);
        System.out.println(user);
    }


    @Test
    public void selectOne2() {
        String sql1 = "select username from c_user where id = ?";
        String username = commonDao.selectOne(sql1, String.class, 2);
        System.out.println(username);
    }

    @Test
    public void selectOne3() {
        String sql2 = "select create_date from c_dept where id = ?";
        Date date = commonDao.selectOne(sql2, Date.class, 1);
        System.out.println(date);
    }


    @Test
    public void selectOne4() {
        String sql3 = "select count(*)  from c_dept  ";
        Integer total = commonDao.selectOne(sql3, Integer.class);
        System.out.println(total);
    }

    @Test
    public void selectOne5() {
        String sql = "select id,username from c_user where id = ? and sex=?";
        User user = commonDao.selectOne(sql, User.class, 2,1);
        System.out.println(user);
    }



    @Test
    public void selectList1() {
        String sql = "select id from c_user where 1=1 ";
        List<Integer> list = commonDao.selectList(sql, Integer.class);
        System.out.println(list);
    }


    @Test
    public void selectList2() {
        String sql = "select id,username,password,name,phone,address,sex,dept_id from c_user where 1=1 ";
        List<User> list = commonDao.selectList(sql, User.class);
        list.forEach(System.out::println);
    }


    @Test
    public void selectPage() {
        String sql = "select id,username,password,name,phone,address,sex,dept_id from c_user where 1=1 ";
        PageRes pageRes = commonDao.selectPage(sql, User.class, 1, 5);
        System.out.println(pageRes);
    }


    @Test
    public void test2(){


        String mail = "123131@qq.com";
        String mail1 = "123131@163.cn";
        String sql  = "select id,username,password,name,phone,address,sex,dept_id from c_user  where id>? ";
        String sql1 = "select count(*) from c_user where id>? ";
        String sql2 = "select count(*) from  ("+sql+") t ";
        System.out.println("原始语句  = "+sql);
        System.out.println("目标语句1 = "+sql1);
        System.out.println("目标语句2 = "+sql2);





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