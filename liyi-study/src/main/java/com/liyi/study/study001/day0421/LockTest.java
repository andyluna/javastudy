package com.liyi.study.study001.day0421;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 19:34  星期三
 */
class Window1 implements Runnable{
    private int ticket=100;

    //创建lock锁
    private ReentrantLock lock=new ReentrantLock();


    @Override
    public void run() {

        while (true){
            try {

                //调用锁定的方法
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":售票，票号为"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {

                //调用解锁的方法
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window1 w=new Window1();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
