package com.andy.study.juc;

import org.junit.Test;

/**
 * TODO:
 *
 * @time: 2020/10/13 十月 15:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class DeadLockTest {

    public static void main(String[] args) {
        final  Object o1 = new Object();
        final  Object o2 = new Object();
        Thread t1 = new Thread(()->{
            synchronized(o1){
                System.out.println(Thread.currentThread().getName()+"获取了o1锁 准备获取o2锁");
                synchronized (o2){
                    System.out.println("获取o2锁");
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized(o2){
                System.out.println(Thread.currentThread().getName()+"获取了o2锁 准备获取o1锁");
                synchronized (o1){
                    System.out.println("获取o1锁");
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }


}
