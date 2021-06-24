package com.liyi.study.study.base.day0412.exer2;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 20:27  星期一
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cust=new Customer("Jane","Smith");

        Account account=new Account(1000,2000,0.0123);

        cust.setAccount(account);

        //存100 取960 取2000
        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(2000);

        System.out.println("Customer["+cust.getLastName()+","+cust.getFirstName()
                + "] has a account : id is"+cust.getAccount().getId()
                +",annualTerestRate is "+cust.getAccount().getAnnualTerestRate()*100
                +"%,balance is "+cust.getAccount().getBalance());
    }
}
