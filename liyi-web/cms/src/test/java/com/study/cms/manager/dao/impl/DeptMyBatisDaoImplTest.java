package com.study.cms.manager.dao.impl;

import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.dao.impl.mybatis.DeptMyBatisDaoImpl;
import com.study.cms.manager.entity.Dept;
import org.junit.Test;

import java.util.Date;
import java.util.List;

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


    @Test
    public void updateDept(){
        int i = deptDao.updateDept(new Dept(57, "大唐mybatis", "999", "001", new Date(), new Date()));
        System.out.println("影响了"+i+"行");
    }


    @Test
    public void queryDeptList(){
        List<Dept> depts = deptDao.queryDeptList("%大唐%", null, "001");
        for (Dept dept:depts){
            System.out.println(dept);
        }
    }

    @Test
    public void queryDeptList1(){
        List<Dept> depts = deptDao.queryDeptList("大唐", null, "001", 2, 10);
        for (Dept dept:depts){
            System.out.println(dept);
        }
    }


    @Test
    public void queryDeptTotal(){
        int i = deptDao.queryDeptTotal("%大唐%", null, null);
        System.out.println(i);
    }

}