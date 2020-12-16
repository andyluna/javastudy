package com.andy.study.jvm.cloader;

/**
 * @time: 2020/10/22 十月 10:47
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println(singleton.count1);
        System.out.println(singleton.count2);
    }

}


class Singleton {
    public static int count1;
    private static Singleton instance = new Singleton();

    private Singleton() {
        count1++;
        count2++;
    }

    public static int count2 = 0;

    public static Singleton getInstance() {
        return instance;
    }
}