package com.andy.study.jvm.heap;

import java.util.concurrent.TimeUnit;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/9/29 20:54  星期二
 */
public class MyHeapDemo02 {

    public static void main(String[] args) {
        System.out.println("MyHeapDemo02 启动");


        try {
            TimeUnit.SECONDS.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
