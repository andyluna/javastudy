package com.andy.study.juc;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO: 两个线程交替输出
 *
 * @time: 2020/10/12 十月 20:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ThreadEachPrintTest {

    Thread t1 = null;
    Thread t2 = null;
    Thread t3 = null;
    char[] aI = "0123456789".toCharArray();
    char[] aC = "ABCDEFGHIG".toCharArray();
    char[] aD = "大唐先一科技有限公司".toCharArray();

    @Test
    public void testLockSupport(){
        t1 = new Thread(()->{
            for(char a:aI){
                System.out.println(Thread.currentThread().getName()+" - "+a);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2 = new Thread(()->{
            for(char a:aC){
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"  --- "+a);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();

        LockSupport.park();

    }

    enum ReadyOrRun{T1,T2}
    private volatile ReadyOrRun r;
    @Test
    public void testCas() throws IOException {
        r = ReadyOrRun.T1;
        t1 = new Thread(()->{
            for(char a:aI){
                while (r!=ReadyOrRun.T1){}
                System.out.println(Thread.currentThread().getName()+" - "+a);
                r=ReadyOrRun.T2;
            }
        },"t1");
        t2 = new Thread(()->{
            for(char a:aC){
                while (r!=ReadyOrRun.T2){  }
                System.out.println(Thread.currentThread().getName()+"  --- "+a);
                r=ReadyOrRun.T1;
             }
        },"t2");
        t1.start();
        t2.start();

    }


    private volatile boolean t2Started = false;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    @Test
    public void testSyncWait() throws InterruptedException {

        final Object o = new Object();
        t1 = new Thread(()->{
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            synchronized (o){
                while (!t2Started){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(char a:aI){
                    System.out.println(Thread.currentThread().getName()+" - "+a);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1");
        t2 = new Thread(()-> {
            synchronized (o) {
                for (char a : aC) {
                    System.out.println(Thread.currentThread().getName() + " ---- " + a);
//                    countDownLatch.countDown();
                    t2Started = true;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2");
        t1.start();
        t2.start();



    }

    //可重用锁
    @Test
    public void testReentrantLock(){
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        t1 = new Thread(()->{
            try{
                lock.lock();
                for(char a:aI){
                    System.out.println(Thread.currentThread().getName()+" - "+a);
                    condition2.signal();
                    condition1.await();
                 }
               // condition1.signal();
//                condition2.signal();
//                condition3.signal();
             }catch  (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t1");
        t2 = new Thread(()-> {
            try{
                lock.lock();
                for(char a:aC){
                    System.out.println(Thread.currentThread().getName()+" ---- "+a);
                    condition3.signal();
                    condition2.await();
                }
//                condition1.signal();
//                condition2.signal();
//                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2");
        t3 = new Thread(()-> {
            try{
                lock.lock();
                for(char a:aD){
                    System.out.println(Thread.currentThread().getName()+" --------- "+a);
                    condition1.signal();
                    condition3.await();
                }
//                condition1.signal();
//                condition2.signal();
//                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();


        try {
            TimeUnit.SECONDS.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //容量为空的 阻塞队列  生产者阻塞
    @Test
    public void testTransferQueue(){
        TransferQueue<Character> transferQueue = new LinkedTransferQueue<>();
        t1 = new Thread(()->{
            try {
                for(char a:aI){
                    transferQueue.take();
                    System.out.println(Thread.currentThread().getName()+" - "+""+" "+a);
                    transferQueue.transfer(a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"t1");
        t2 = new Thread(()-> {
            try {
                for(char a:aC){
                    transferQueue.transfer(a);
                    transferQueue.take();
                    System.out.println(Thread.currentThread().getName()+" ------ "+""+" "+a);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Thread t1 = null;
        Thread t2 = null;
        char[] aI = "0123456789".toCharArray();
        char[] aC = "ABCDEFGHIG".toCharArray();
        final Object o = new Object();
        t1 = new Thread(()->{
            synchronized (o){
                for(char a:aI){
                    System.out.println(Thread.currentThread().getName()+" - "+a);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }
        },"t1");
        t2 = new Thread(()->{
            synchronized (o){
                for(char a:aC){
                    System.out.println(Thread.currentThread().getName()+" ---- "+a);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2");
        t1.start();
        t2.start();
    }


}
