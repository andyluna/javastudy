package com.andy.study.juc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 13:56
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BlockingQueryTest {
    //先进先出阻塞队列
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue);
        //会报异常
        boolean add = blockingQueue.add(1);
        boolean add1 = blockingQueue.add(2);
        boolean add2 = blockingQueue.add(3);
        System.out.println(blockingQueue);

        Integer element = blockingQueue.element();


        System.out.println(element);
        System.out.println(blockingQueue);
        boolean remove = blockingQueue.remove(3);
        boolean remove2 = blockingQueue.remove(34);
        System.out.println(blockingQueue);



        //返回默认值
        boolean offer = blockingQueue.offer(3);
        Integer poll = blockingQueue.poll();
        Integer peek = blockingQueue.peek();

        //阻塞
        blockingQueue.put(1);
        Integer take = blockingQueue.take();


        //等待一段时间
        boolean offer1 = blockingQueue.offer(3,200, TimeUnit.MILLISECONDS);
        Integer poll1 = blockingQueue.poll(200, TimeUnit.MILLISECONDS);


        AtomicInteger ai = new AtomicInteger(1);

        System.out.println("ai.get() ="+ai.get());
        System.out.println("ai.getAndIncrement() ="+ai.getAndIncrement());
        //System.out.println(ai.incrementAndGet());
    }
}
