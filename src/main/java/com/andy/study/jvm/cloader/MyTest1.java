package com.andy.study.jvm.cloader;

/**
 * -XX:+TraceClassLoading 用于追踪类的加载情况
 * @time: 2020/10/22 十月 09:00
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.str1);//不打印 MyChild1 的static字段
        //System.out.println(MyChild1.str2);//先打印 Myparent1 的static 再打印 MyChild1 的static字段
    }
}

class Myparent1{

    public static String str1 = "hello world";

    static{
        System.out.println("parent static");
    }
}

class MyChild1 extends Myparent1{
    public static String str2 = "chile static str";

    static{
        System.out.println("child static");
    }
}