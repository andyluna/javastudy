package com.andy.study.shutdown;

/**
 * @time: 2020/12/14 十二月 15:45
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("你好");
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new MyShutdownHook("myshutdown-hook"));
    }

    public static class MyShutdownHook extends Thread {

        public MyShutdownHook(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("我要关闭了");
        }
    }

}
