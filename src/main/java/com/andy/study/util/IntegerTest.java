package com.andy.study.util;

import java.lang.reflect.Field;

/**
 * TODO:
 *
 * @time: 2020/10/10 十月 10:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class IntegerTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

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
