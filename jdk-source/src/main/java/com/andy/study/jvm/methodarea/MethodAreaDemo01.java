package com.andy.study.jvm.methodarea;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/10/1 十月 22:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MethodAreaDemo01 {

    public static void main(String[] args) {

        System.out.println("MethodAreaDemo01 start");

        try {
            TimeUnit.SECONDS.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MethodAreaDemo01 end");


    }


}
