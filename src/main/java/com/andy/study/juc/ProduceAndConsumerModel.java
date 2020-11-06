package com.andy.study.juc;

import java.net.PasswordAuthentication;

/**
 * @time: 2020/11/4 十一月 19:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ProduceAndConsumerModel {
    private int a = 0;
    private Object lock = new Object();
    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (lock){
            if(isProduced){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("消费者生存一个:"+(++a));
                isProduced = true;
                lock.notify();
            }
        }
    }
    public void consumer()  {
        synchronized (lock){
            if(isProduced){
                System.out.println("消费者消费一个产品:"+a);
                isProduced = false;
                lock.notify();
            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceAndConsumerModel pas = new ProduceAndConsumerModel();
        new Thread(()->{
            while (true){
                pas.produce();

            }

        },"A").start();
        new Thread(()->{
            while (true) {
                pas.consumer();

            }
        },"B").start();


    }
}
