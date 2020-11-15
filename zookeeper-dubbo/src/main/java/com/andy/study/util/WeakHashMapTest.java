package com.andy.study.util;

import org.junit.Test;

import java.util.WeakHashMap;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/7 23:20  星期三
 */
public class WeakHashMapTest {


    @Test
    public void test1() throws InterruptedException {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        for (int i=0;i<1000;i++){
            map.put(i,String.valueOf(i));
        }
        System.out.println(map.size());
        System.out.println(map.get(200));




        System.gc();
        System.runFinalization();
        Thread.sleep(6000);

        System.out.println(map.size());
        System.out.println(map.get(200));
    }




}
