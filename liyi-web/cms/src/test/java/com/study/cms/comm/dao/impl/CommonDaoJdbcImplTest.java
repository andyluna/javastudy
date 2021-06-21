package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
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

    @After
    public void after(){
        commonDao =null;
        System.out.println("执行之后");
    }
}