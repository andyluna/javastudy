package com.andy.study.jvm.cloader;


/**
 * @time: 2020/10/22 十月 14:49
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest12 {

    public static void main(String[] args) throws Exception {


        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Class<?> aClass = classLoader.loadClass("com.andy.study.jvm.cloader.CL");

        System.out.println(aClass);
        //System.out.println(aClass.newInstance());

        System.out.println("-----------");
        aClass = Class.forName("com.andy.study.jvm.cloader.CL");
        System.out.println(aClass);
    }

}

class CL {
    static {
        System.out.println("CL init");
    }
}