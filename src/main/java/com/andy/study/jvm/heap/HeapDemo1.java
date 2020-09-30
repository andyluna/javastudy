package com.andy.study.jvm.heap;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/9/29 九月 17:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("Demo1开始");

        try {
            TimeUnit.SECONDS.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Demo1结束");


    }
}
