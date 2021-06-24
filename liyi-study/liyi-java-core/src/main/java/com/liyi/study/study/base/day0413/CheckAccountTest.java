package com.liyi.study.study.base.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 20:07  星期二
 */
public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount account=new CheckAccount(1122,20000,0.045,5000);

        account.withdraw(5000);
        System.out.println("您的账户余额为："+account.getBalance());
        System.out.println("您的可透支额度为："+account.getOverdraft());
        account.withdraw(18000);
        System.out.println("您的账户余额为："+account.getBalance());
        System.out.println("您的可透支额度为："+account.getOverdraft());
        account.withdraw(3000);
        System.out.println("您的账户余额为："+account.getBalance());
        System.out.println("您的可透支额度为："+account.getOverdraft());
    }
}
