package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.manager.entity.Dept;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/23 23:54  星期三
 */
public class CommonDaoEnhanceIdbcImplTest {
    private CommonDaoEnhance commonDaoEnhance;
    @Before
    public void before() {
        commonDaoEnhance = new CommonDaoEnhanceIdbcImpl();
    }

    @After
    public void after() {
        commonDaoEnhance = null;
    }



    @Test
    public void update() {
        Dept dept = new Dept();
        dept.setId(2);
        dept.setName("测试修改");
        dept.setCode("测试修改007");
        dept.setLastUpdateDate(new Date());
        commonDaoEnhance.update(dept);
    }

    @Test
    public void insert() {
        Dept dept = new Dept();
        dept.setName("李逸新增部门1");
        dept.setCode("李逸新增部门1007");
        dept.setCreateDate(new Date());
        dept.setLastUpdateDate(new Date());
        dept.setParentCode("001");
        commonDaoEnhance.insert(dept);
    }

    @Test
    public void deleteById() {
        commonDaoEnhance.deleteById(Dept.class,58);
    }

    @Test
    public void delete() {
        Dept dept = new Dept();
        dept.setName("大唐子公司199");
        dept.setCode("00199");
        dept.setParentCode("001");
        commonDaoEnhance.delete(dept);
    }


    @Test
    public void selectOne() {
        Dept dept = new Dept();
        dept.setName("大唐子公司36");
        dept.setCode("00136");
        dept.setParentCode("001");
        Dept o = commonDaoEnhance.selectOne(dept);
        System.out.println(o );
    }


}