package com.andy.study.jvm.cloader;

/**
 * @time: 2020/10/22 十月 14:30
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());
        Class<?> aClass1 = Class.forName("com.andy.study.jvm.cloader.C");
        System.out.println(aClass1.getClassLoader());
    }
}


class C {

}