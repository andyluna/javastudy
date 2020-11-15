package com.andy.study.juc.tools;

import java.util.concurrent.Semaphore;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 10:05
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SemaphoreTest {

    private static int n = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);



        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" 尝试获取一个信号量 ");
                    semaphore.acquire();
                    n = n+1;
                    System.out.println(Thread.currentThread().getName()+" 已经获取到了一个 当前可以信号量 = "+semaphore.availablePermits()+" n = "+n);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }


            },i+"").start();

        }

    }
}
