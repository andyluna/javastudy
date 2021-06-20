package com.study.cms.manager.dao;

import com.study.cms.manager.dao.impl.DeptDaoImpl;
import com.study.cms.manager.dao.impl.UserDaoImpl;
import com.study.cms.manager.entity.Dept;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 22:58  星期六
 */
public class DeptDaoTest {
    private DeptDao deptDao = new DeptDaoImpl();
    @Test
    public void addDept() {
        Dept dept = new Dept(null, "大唐能源集团", "001", null, new Date(), new Date());
        deptDao.addDept(dept);
    }

    @Test
    public void addDeptList() {
        for (int i = 0; i < 50; i++) {
            Dept dept = new Dept(null, "大唐子公司"+i, "001"+i, "001", new Date(), new Date());
            deptDao.addDept(dept);
        }

    }


    @Test
    public void queryDeptById(){
        Dept dept = deptDao.queryDeptById(52);
        System.out.println(dept);
    }

}