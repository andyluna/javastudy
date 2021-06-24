package com.liyi.study.study.base.day0416;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/16 17:19  星期五
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();
        System.out.println(bank1==bank2);
    }


}

class Bank{

    //私有化的构造器
    private Bank(){

    }

    //内部类创建类的对象，要求此对象也必须声明为静态的
    private static Bank instance=new Bank();

    //提供公共的静态的方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
