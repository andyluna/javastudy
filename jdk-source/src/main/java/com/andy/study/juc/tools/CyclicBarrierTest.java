package com.andy.study.juc.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 09:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> {
            System.out.println("CyclicBarrier线程开始干活了");
        });

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                cb.await();
                cb.await(1, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + "等待完成");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                Thread.sleep(2000);
                cb.await();
                System.out.println(Thread.currentThread().getName() + "等待完成");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }, "t2").start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                cb.await();
                System.out.println(Thread.currentThread().getName() + "等待完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }, "t3").start();
    }
}
