package com.liyi.study.base.day0416;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/16 17:04  星期五
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acc1=new Account();
        Account acc2=new Account("qwerty",2000);
        Account.setInteresRate(0.0012);
        Account.setMinMoney(2.0);

        System.out.println(acc2);
        System.out.println(acc1);

    }



}
