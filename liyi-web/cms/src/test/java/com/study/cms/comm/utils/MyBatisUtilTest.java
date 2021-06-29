package com.study.cms.comm.utils;

import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.mapper.DeptMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 23:24  星期二
 */
public class MyBatisUtilTest {


    @Test
    public void test1(){
        SqlSession session = MyBatisUtil.getSession(true);

        Dept dept = new Dept();
        dept.setName("大唐子公司%");

        List<Object> objects = session.selectList("com.study.cms.manager.mapper.DeptMapper.selectAll",dept);
        objects.forEach(System.out::println);
    }


//    @Test
//    public void test2(){
//        SqlSession session = MyBatisUtil.getSession(true);
//        DeptMapper deptMapper = session.getMapper(DeptMapper.class);
//        Dept dept = new Dept();
//        dept.setName("大唐子公司%");
//        List<Dept> depts = deptMapper.selectAll(dept);
//        depts.forEach(System.out::println);
//    }

}