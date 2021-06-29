package com.study.cms.manager.dao.impl;

import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.entity.Dept;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 23:46  星期二
 */
public class DeptMyBatisDaoImplTest {
    private DeptDao deptDao = new DeptMyBatisDaoImpl();
    @Test
    public void queryByName() {
        Dept dept = deptDao.queryByName("大唐能源集团");
        System.out.println(dept);
    }

    @Test
    public void queryByName1() {
        Dept dept = deptDao.queryByName(1,"大唐能源集团");
        System.out.println(dept);
    }

}