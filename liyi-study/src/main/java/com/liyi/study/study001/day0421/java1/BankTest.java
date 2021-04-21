package com.liyi.study.study001.day0421.java1;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 19:06  星期三
 */
public class BankTest {
}


class Bank{
    private Bank(){ }

    private static Bank instance=null;

//    public static synchronized Bank getInstance(){
//        if(instance==null){
//            instance=new Bank();
//        }
//        return instance;
//    }

    //方式一
//    public static Bank getInstance() {
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //方式二 效率稍高
    public synchronized Bank getInstance(){
        if(instance==null){
            synchronized (Bank.class){
                if (instance==null){
                instance=new Bank();
            }
           }
        }
        return instance;
    }



}
