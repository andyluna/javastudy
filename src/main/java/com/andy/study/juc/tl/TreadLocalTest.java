package com.andy.study.juc.tl;

/**
 * @time: 2020/11/11 十一月 15:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class TreadLocalTest {

//    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
//        @Override
//        protected String initialValue() {
//            System.out.println("初始化");
//            return "xiangdan";
//        }
//    };
    public static void main(String[] args) {
        MyThread myThreadA = new MyThread();
        myThreadA.setName("ThreadA");

        MyThread myThreadB = new MyThread();
        myThreadB.setName("ThreadB");

        myThreadA.start();
        myThreadB.start();
    }



    static class MyThread extends Thread {
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 5;
            }
        };

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
                threadLocal.set(i);
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
            }
        }
    }


}
