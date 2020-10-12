package com.andy.study.util;

import java.lang.reflect.Field;

/**
 * TODO:
 *
 * @time: 2020/10/10 十月 10:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class IntegerTest {

    public static void main(String[] args)  {
        test2();

    }

    public static void test2(){
        Integer a = new Integer(10);
        Integer b = Integer.valueOf(10);
        Integer c = 10;
        Integer d = Integer.parseInt("10");

        System.out.println(a ==b);
        System.out.println(a ==c);
        System.out.println(a ==d);

        System.out.println("--------");
        System.out.println(c ==b);
        System.out.println(c ==d);
        System.out.println(b ==d);


    }

    public static void test1() throws NoSuchFieldException, IllegalAccessException{
        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3

        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
    }


}
