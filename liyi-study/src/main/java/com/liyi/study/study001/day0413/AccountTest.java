package com.liyi.study.study001.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 19:47  星期二
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(1122,20000,0.045);

        acct.withdraw(30000);
        System.out.println("您的账户余额为："+acct.getBalance());

        acct.withdraw(2500);
        System.out.println("您的账户余额为："+acct.getBalance());

        acct.deposit(3000);
        System.out.println("月利率为："+(acct.getMonthlyInterest())*100+"%");
    }



}
