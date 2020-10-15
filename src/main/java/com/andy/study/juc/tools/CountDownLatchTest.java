package com.andy.study.juc.tools;

import java.util.concurrent.CountDownLatch;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 09:15
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //countDownLatch.await();

        long count = countDownLatch.getCount();

        System.out.println(count);

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }, "t1").start();

        new Thread(() -> {

            countDownLatch.countDown();
        }, "t2").start();

        new Thread(() -> {

            countDownLatch.countDown();
        }, "t3").start();

        countDownLatch.await();

        System.out.println("主线程开始执行了");


    }
}
