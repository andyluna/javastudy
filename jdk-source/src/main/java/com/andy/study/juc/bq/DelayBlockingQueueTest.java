package com.andy.study.juc.bq;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 15:26
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class DelayBlockingQueueTest {
    private static DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {

                delayQueue.put(new MyDelayedTask("task1", 10000));
                delayQueue.put(new MyDelayedTask("task2", 3900));
                delayQueue.put(new MyDelayedTask("task3", 1900));
                delayQueue.put(new MyDelayedTask("task4", 5900));
                delayQueue.put(new MyDelayedTask("task5", 6900));
                delayQueue.put(new MyDelayedTask("task6", 7900));
                delayQueue.put(new MyDelayedTask("task7", 4900));

            }
        }).start();

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take);
        }
    }

    /**
     * compareTo 方法必须提供与 getDelay 方法一致的排序
     */
    public static class MyDelayedTask implements Delayed {
        private String name;
        private long start = System.currentTimeMillis();
        private long time;

        public MyDelayedTask(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((start + time) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            MyDelayedTask o1 = (MyDelayedTask) o;
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "MyDelayedTask{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    '}';
        }
    }
}
