package com.andy.study.util.arr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/7 17:45  星期三
 */
public class LinkedListTest {

    private static final int SIZE = 100000;//10万


    @Test
    public void test1(){
        Random r = new Random();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new Vector<>();
        List<Integer> list3 = new LinkedList<>();

        Integer[] integers = new Integer[100000];
        for (int i = 0; i < SIZE; i++) {
            integers[0]=i;
        }


        List<Integer> list4 = Arrays.asList(integers);


        list1 = new ArrayList<>(list4);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list1.indexOf(r.nextInt(SIZE));
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 查询耗时 = "+(end-start));
        list2 = new Vector<>(list4);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list2.indexOf(r.nextInt(SIZE));
        }
        end = System.currentTimeMillis();
        System.out.println("Vector 查询耗时 = "+(end-start));


        list3 = new LinkedList<>(list4);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list3.indexOf(r.nextInt(SIZE));
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList 查询耗时 = "+(end-start));
     }
    @Test
    public void test2(){
        Queue<Integer> ll = new LinkedList<>();

        boolean add = ll.add(1);//增加一个元索
        Integer remove = ll.remove();//移除并返回队列头部的元素
        Integer element = ll.element();//返回队列头部的元素


        ll.offer(1);//添加一个元素并返回true
        ll.poll();//移除并返问队列头部的元素
        ll.peek();//返回队列头部的元素




        System.out.println(ll);
    }

}
