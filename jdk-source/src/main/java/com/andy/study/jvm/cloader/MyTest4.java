package com.andy.study.jvm.cloader;

import java.lang.reflect.Array;

/**
 * anewarray 创建引用类型的数组
 * newarray 创建基本类型的数组
 *
 * @time: 2020/10/22 十月 10:32
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest4 {
    public static void main(String[] args) {
        //Myparent4 myparent4 = new Myparent4();

        Myparent4[] myparent42 = new Myparent4[3];
//
        System.out.println(myparent42);


        Object o = Array.newInstance(Myparent4.class, 2);

        System.out.println(o.getClass());

        System.out.println(myparent42.getClass() == o.getClass());


        System.out.println("----------");
        int[] a = new int[3];
    }
}

class Myparent4 {
    static {
        System.out.println("my test4 block");
    }
}
