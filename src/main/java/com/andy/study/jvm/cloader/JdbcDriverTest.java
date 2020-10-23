package com.andy.study.jvm.cloader;


import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @time: 2020/10/23 十月 14:06
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class JdbcDriverTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("jdbc.drivers"));
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("aClass = "+aClass);

        CC cc = new CC();
        cc.test1();
    }


    public static void test1(){


        Class<?> callerClass = Reflection.getCallerClass();

        System.out.println(callerClass);
    }

}


class CC{

    public void test1(){
        test2();
    }


    public  void test2(){
        System.out.println(Reflection.getCallerClass(-1));
        System.out.println(Reflection.getCallerClass(0));
        System.out.println(Reflection.getCallerClass(1));
        System.out.println(Reflection.getCallerClass(2));
        System.out.println(Reflection.getCallerClass(3));
        System.out.println(Reflection.getCallerClass(4));
        System.out.println(Reflection.getCallerClass(5));
    }

}