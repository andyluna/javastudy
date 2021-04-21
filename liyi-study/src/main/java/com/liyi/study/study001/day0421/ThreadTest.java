package com.liyi.study.study001.day0421;

/**
 * 多线程的创建：
 * 1.创建一个继承于Thread的子类
 * 2.重写Thread类的run()====>将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 11:04  星期三
 */
class MyThread extends Thread{

    public void run(){
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

}

public class ThreadTest{
    public static void main(String[] args) {
//        MyThread t1=new MyThread();
//        t1.start();
//
//        MyThread t2=new MyThread();
//        t2.start();

//        for (int i=0;i<100;i++){
//            if(i%2==0){
//                System.out.println("**********main*********");
//            }
//        }

        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {

                for (int i=0;i<100;i++){
                    if(i%2==0){
                        System.out.println("**********main*********");
            }
        }
            }
        }.start();

    }
}
