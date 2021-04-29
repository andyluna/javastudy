package com.liyi.study.base.day0421;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 15:02  星期三
 */

class Window2 extends Thread{

    private static int ticket=100;

    private static Object obj=new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }


    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1=new Window2();
        Window2 w2=new Window2();
        Window2 w3=new Window2();

        Thread t1=new Thread(w1);
        Thread t2=new Thread(w2);
        Thread t3=new Thread(w3);


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
