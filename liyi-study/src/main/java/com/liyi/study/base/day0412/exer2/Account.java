package com.liyi.study.base.day0412.exer2;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 20:07  星期一
 */
public class Account {


    private int id;//账号
    private double balance;//余额
    private double annualTerestRate;//年利率

    public Account(int id,double balance,double annualTerestRate){
        this.id=id;
        this.balance=balance;
        this.annualTerestRate=annualTerestRate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualTerestRate() {
        return annualTerestRate;
    }

    public void setAnnualTerestRate(double annualTerestRate) {
        this.annualTerestRate = annualTerestRate;
    }


    //提款方法，需要判断用户余额是否能够满足提款数额的要求，如果不能，应该给出提示
    public void withdraw(double amount){
        if(balance<amount){
            System.out.println("余额不足，取款失败");
            return;
        }
        balance-=amount;
        System.out.println("成功取出："+amount);
    }

    //存钱
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("成功存入："+amount);
        }
    }

}
