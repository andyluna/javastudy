package com.liyi.study.base.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 19:52  星期二
 */
public class CheckAccount extends Account{

    private double overdraft;//可透支的限额


    public CheckAccount(int id,double balance,double annuaInterestRate,double overdraft){
        super(id,balance,annuaInterestRate);
        this.overdraft=overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    //取钱
    public void withdraw(double amount){

        if (getBalance()>=amount){//余额足够消费
            super.withdraw(amount);
            return;
        }else if (overdraft>=amount-getBalance()){//透支额度+余额足够消费
            overdraft-=(amount-getBalance());
            //setBalance(0);
            super.withdraw(getBalance());
        }else{
            System.out.println("超过可透支限额");
        }

    }


}
