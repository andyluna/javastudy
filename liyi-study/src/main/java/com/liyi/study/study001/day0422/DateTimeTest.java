package com.liyi.study.study001.day0422;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 15:07  星期四
 */
public class DateTimeTest {

    @Test
    public void test1(){
        long time=System.currentTimeMillis();
        System.out.println(time);
    }


    @Test
    public void test2(){
        Date date1=new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2=new Date(1619075700832L);
        System.out.println(date2);

        java.sql.Date date3=new java.sql.Date(1619075700832L);
        System.out.println(date3);

        Date d1=new Date();
        java.sql.Date d2=new java.sql.Date(d1.getTime());
    }


    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat();

        Date date=new Date();
        System.out.println(date);

        //格式化日期----》字符串
        String format=sdf.format(date);
        System.out.println(format);

        //逆格式化 字符串----->日期
        String str="19/12/18 下午18:22";
        Date date1=sdf.parse(str);
        System.out.println(date1);
    }


    @Test
    public void test4() throws ParseException {

        String birth="2020-09-08";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(birth);

        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    @Test
    public void test5(){

        Calendar calendar=Calendar.getInstance();

        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.set(Calendar.DAY_OF_MONTH,24);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        calendar.add(Calendar.DAY_OF_MONTH,3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //日历类--->Date
        Date date=calendar.getTime();
        System.out.println(date);

        //Date---->日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
