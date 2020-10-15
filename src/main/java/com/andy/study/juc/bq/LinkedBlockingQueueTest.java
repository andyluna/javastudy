package com.andy.study.juc.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 14:46
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Integer> bq = new LinkedBlockingDeque(3);
        bq.offer(1);
        bq.offer(2);
        bq.offer(3);
//        bq.add(1);
//        bq.add(2);
//        bq.add(3);

       // boolean offer = bq.offer(4);
        System.out.println(bq);
        System.out.println(bq.peek());
        System.out.println(bq.poll());
    }

}
