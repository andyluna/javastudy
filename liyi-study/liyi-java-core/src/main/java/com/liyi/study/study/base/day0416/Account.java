package com.liyi.study.study.base.day0416;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/16 16:56  星期五
 */
public class Account {

    private int id;
    private String pwd="000000";
    private double balance;

    private static double interesRate;

    private static double minMoney=1.0;

    private static int init=1001;//自动生成id

    public double getBalance() {
        return balance;
    }



    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    public static double getInteresRate() {
        return interesRate;
    }

    public static void setInteresRate(double interesRate) {
        Account.interesRate = interesRate;
    }

    public int getId() {
        return id;
    }

    public Account(){
        id=init++;

    }

    public Account(String pwd,double balance){
        id=init++;
        this.pwd=pwd;
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
