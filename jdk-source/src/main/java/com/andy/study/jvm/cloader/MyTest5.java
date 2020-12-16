package com.andy.study.jvm.cloader;

import java.util.Random;

/**
 * 当接口初始化时 并不要求父接口初始化完成
 *
 * @time: 2020/10/22 十月 10:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}


interface Myparent5 {
    public static final int a = new Random().nextInt(4);
}

interface MyChild5 extends Myparent5 {
    public static final int b = 3;
}
