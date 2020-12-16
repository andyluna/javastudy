package com.andy.study.jvm.cloader;

import java.util.UUID;

/**
 * @time: 2020/10/22 十月 10:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(Myparent3.str);
    }
}

class Myparent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Myparent3");
    }
}
