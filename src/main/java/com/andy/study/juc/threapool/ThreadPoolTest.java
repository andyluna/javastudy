package com.andy.study.juc.threapool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 17:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ThreadPoolTest {
    private static  AtomicInteger ai = new AtomicInteger();
    public static void main(String[] args) throws IOException {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler reh1 = new ThreadPoolExecutor.AbortPolicy();//直接拒绝 抛异常

        RejectedExecutionHandler reh2 = new ThreadPoolExecutor.CallerRunsPolicy();//调用当前工作线程来执行该任务
        RejectedExecutionHandler reh3 = new ThreadPoolExecutor.DiscardPolicy();//如果线程池队列满了，会直接丢掉这个任务并且不会有任何异常
        RejectedExecutionHandler reh4 = new ThreadPoolExecutor.DiscardOldestPolicy();//也就是说如果队列满了，会将最早进入队列的任务删掉腾出空间

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 5, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                threadFactory,reh4);

        for(int i =0 ; i<100;i++){
            tpe.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" "+ai.incrementAndGet());
            });
        }

        Thread.interrupted();

        tpe.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    }


}
