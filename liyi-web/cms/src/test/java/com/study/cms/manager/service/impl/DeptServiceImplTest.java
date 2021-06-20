package com.study.cms.manager.service.impl;

import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.service.DeptService;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/20 10:22  星期日
 */
public class DeptServiceImplTest {
    DeptService deptService=new DeptServiceImpl();

    @Test
    public void addDept() {
        Date create=new Date();
        Date update=new Date();
        deptService.addDept(new Dept(null,"大唐子公司199","00199","001",create,update));
    }

    @Test
    public void queryDeptByIdTest(){
        Dept dept = deptService.queryDeptById(52);
        System.out.println(dept);
    }

    @Test
    public void update() throws ParseException {
        deptService.updateDept(new Dept(53,"大唐777","00777","001",new Date(),new Date()));

    }


    @Test
    public void stringUpdateDate(){
        String s="2021-06-20";
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年-MM月-dd日 HH:mm:ss");
        try {
            Date date=formatter.parse(s);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Sun Jun 20 11:23:08 CST 2021

    @Test
    public void date1(){
        // 获得当前时间
        Date date = new Date();
        System.out.println(date);   //Sun Jun 20 15:57:27 CST 2021
        // 获得SimpleDateFormat类
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");
        //打印当前时间
        System.out.println("当前时间:"+sf.format(date));  //当前时间:2021年-06月-20日 15:57:27

    }

    @Test
    public void date2() {
        //获得一个时间格式的字符串
        String dateStr = "2016-12-31 11:30:22";
        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            Date date = sf.parse(dateStr);
            //打印Date
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();


        }
    }

}