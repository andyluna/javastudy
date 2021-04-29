package com.liyi.study.base.day0421;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 21:09  星期三
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //提供指定线程数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);

        //执行指定的线程的操作
        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());
        service.shutdown();//关闭连接池

    }
}
