package com.andy.study.jvm.cloader;

/**
 * @time: 2020/10/22 十月 14:42
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(MyChild11.a);

        MyChild11.doSomething();

    }

}


class Myparent11 {
    public static int a = 3;

    static {
        System.out.println("Myparent11 static");
    }

    public static void doSomething() {
        System.out.println("Myparent11 do some thing ");
    }
}

class MyChild11 extends Myparent11 {
    //public static int a = 4;
    static {
        System.out.println("MyChild11 static");
    }

    public static void doSomething() {
        System.out.println("MyChild11 do some thing ");
    }
}