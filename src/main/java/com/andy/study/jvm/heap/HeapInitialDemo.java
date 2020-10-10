package com.andy.study.jvm.heap;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/9/30 九月 09:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class HeapInitialDemo {


    public static void main(String[] args) {

        System.out.println("Hello World");

        try {
            TimeUnit.SECONDS.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
