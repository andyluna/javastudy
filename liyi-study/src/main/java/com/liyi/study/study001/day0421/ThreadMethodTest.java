package com.liyi.study.study001.day0421;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 12:12  星期三
 */

class HelloThread extends Thread{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

//            if (i%20==0){
//                yield();
//            }
        }


    }

    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1=new HelloThread("Thread：1");

//        h1.setName("线程1");

        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");


        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if (i==20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
