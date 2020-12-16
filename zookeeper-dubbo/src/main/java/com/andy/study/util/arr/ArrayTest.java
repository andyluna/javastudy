package com.andy.study.util.arr;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/7 15:46  星期三
 */
public class ArrayTest {

    @Test
    public void test1() {
        User[] u1 = new User[2];
        Class<?> type = u1.getClass().getComponentType();
        System.out.println(type);
        User[] o = (User[]) Array.newInstance(User.class, 2);
        System.out.println(o);
        User[][] o1 = (User[][]) Array.newInstance(User.class, 1, 2);
        System.out.println(o1);
    }

    @Test
    public void test3() {
        Integer[] in3 = {1, 2, 3};
        System.out.println(in3 + " " + Arrays.toString(in3));

        Integer[] in4 = Arrays.copyOf(in3, 4);


        System.out.println(in3 + " " + Arrays.toString(in3));

        System.out.println(in4 + " " + Arrays.toString(in4));


    }


    @Test
    public void test2() {
        List<Integer> li = new ArrayList<>(10);
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        li.add(6);
        li.add(7);
        li.add(8);
        li.add(9);
        li.add(10);
        li.add(11);

    }


}
