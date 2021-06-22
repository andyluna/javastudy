package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.manager.entity.User;
import org.junit.Test;

import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 9:52  星期二
 */
public class Test1 {
    CommonDao commonDao=new CommonDaoJdbcImpl();

    @Test
    public void test1(){
    String sql = "select id,username,password,name,phone,address,sex,dept_id from c_user where parent_code=001";
    User user = commonDao.selectOne(sql, User.class, 1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        String sql2="insert into c_menu(name,url,open_type,parent_id,create_date,last_update_date)values(?,?,?,?,?,?)";
        commonDao.update(sql2,"菜单2","http://www.baidu.com","当前页",001,new Date(),new Date());
    }

    @Test
    public void test3(){
        String sql3="delete from c_menu where id=?";
        commonDao.update(sql3,56);
    }

}
