package com.andy.study.juc.bq;

import java.util.concurrent.SynchronousQueue;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 17:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        synchronousQueue.put(2);


        System.out.println(synchronousQueue);
    }
}
