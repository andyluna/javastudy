package com.andy.study.juc;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/10/12 十月 14:56
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        Thread.State state1 = thread.getState();

        System.out.println(state1);
        System.out.println(thread.getPriority());
        System.out.println(thread.getThreadGroup());

        T1 t1 = new T1("t1");

        int priority = t1.getPriority();
        Thread.State state = t1.getState();
        System.out.println(priority);
        System.out.println(state);
        System.out.println(t1.getThreadGroup());


        T1 t2 = new T1("t2");
        int priority2 = t2.getPriority();
        System.out.println(priority2);
        System.out.println(t2.getThreadGroup());

        new Thread(() -> {

        }, "t3");

    }
}

class T1 extends Thread {
    public T1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName() + " - " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}