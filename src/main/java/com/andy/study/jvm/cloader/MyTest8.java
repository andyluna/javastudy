package com.andy.study.jvm.cloader;

import java.util.Random;

/**
 * @time: 2020/10/22 十月 14:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.b);
    }

}


class FinalTest{
    public static final int a = 3;//new Random().nextInt(13);
    public static final int b = new Random().nextInt(13);
    static {
        System.out.println("FinalTest block");
    }
}
