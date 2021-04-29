package com.liyi.study.base.day0421;

/**
 * 通过Runnable接口的方式创建线程
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 15:13  星期三
 */
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        MThread m1=new MThread();

        Thread t1=new Thread(m1);

        t1.start();
    }


}
