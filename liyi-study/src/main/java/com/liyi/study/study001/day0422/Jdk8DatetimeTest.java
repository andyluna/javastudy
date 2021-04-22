package com.liyi.study.study001.day0422;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 19:18  星期四
 */
public class Jdk8DatetimeTest {

    @Test
    public void test1(){
        //获取当前
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of:设置指定的年月日时分秒
        LocalDateTime localDateTime1=LocalDateTime.of(2020,8,22,2,15,52);
        System.out.println(localDateTime1);

        //get
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfMonth());


        //不可变性
        LocalDate localDate1=localDate.withDayOfMonth(23);
        System.out.println(localDate1);
        System.out.println(localDate);

        LocalDateTime localDateTime2=localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3=localDateTime.minusMonths(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

    }

    @Test
    public void test2(){
        //获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }


    @Test
    public void test3(){

        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime localDateTime=LocalDateTime.now();
        String str=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);

        //字符串---->日期
        TemporalAccessor parse=formatter.parse("2021-04-22T19:47:57.5491508");
        System.out.println(parse);

//        DateTimeFormatter formatter1=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        String str1=formatter1.format(localDateTime);
//        System.out.println(str1);


    }


    @Test
    public void test4(){
        DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        String str=formatter.format(LocalDateTime.now());
        System.out.println(str);



    }


}
