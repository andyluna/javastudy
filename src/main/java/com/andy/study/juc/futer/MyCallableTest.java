package com.andy.study.juc.futer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 11:30
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyCallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"MyCallableTest run");
        Thread.sleep(2000);
        return "andy";
    }


    public static void main(String[] args) throws Exception {
        MyCallableTest callableTest = new MyCallableTest();
        FutureTask<String> futureTask = new FutureTask<>(callableTest);

        new Thread(futureTask,"t1").start();

        boolean done = futureTask.isDone();
        System.out.println("主线程"+done);

        while(!futureTask.isDone()){


            String s = futureTask.get();
            System.out.println(s);
        }








        Thread.sleep(10000);
    }

}
