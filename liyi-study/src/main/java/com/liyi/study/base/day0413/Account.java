package com.liyi.study.base.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 19:41  星期二
 */
public class Account {
    private int id;//账号

    private double balance;//余额

    private double annuaInterestRate;//年利率

    public Account(int id, double balance, double annuaInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuaInterestRate = annuaInterestRate;
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

    public double getAnnuaInterestRate() {
        return annuaInterestRate;
    }

    public void setAnnuaInterestRate(double annuaInterestRate) {
        this.annuaInterestRate = annuaInterestRate;
    }


    //返回月利率
    public double getMonthlyInterest(){

        return annuaInterestRate/12;
    }

    //取钱
    public void withdraw(double amount){

        if (balance>=amount){
            balance-=amount;
            return;
        }
        System.out.println("余额不足");
    }


    //存钱
    public void deposit(double amount){

        if(amount>0){
            balance+=amount;
        }
    }
}
