package com.andy.study.jvm.cloader;

/**
 * 常量在编译阶段 会存到调用这个方法的常量池当中
 * ldc 表示将int float String等常量 从常量池推送至栈顶
 * bipush 表示将单字节 -128~127 的常量推送至常量池
 * sipush 表示将短整型 -32768~32767 的常量推送至常量池
 * iconst_1 表示将 -1 到 5 常量推送至栈顶  iconst_m1到iconst_5
 * @time: 2020/10/22 十月 10:06
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2{
    public static final String str1 = "123";
    public static final short  s= 7;
    public static final int  i= 128;
    public static final int  i2= 32769;
    public static final int  m= 1;
    static{
        System.out.println("My parent block");
    }
}
