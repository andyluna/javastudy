package com.liyi.study.base.day0414;

import com.liyi.study.base.day0412.exer2.Customer;

import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 20:29  星期三
 */
public class ToStringTest {
    public static void main(String[] args) {
        Customer cust1=new Customer("tom","jack");
        System.out.println(cust1.toString());

        System.out.println(cust1);

        String str=new String("MM");
        System.out.println(str);

        Date date=new Date(12112212L);
        System.out.println(date.toString());
    }
}
