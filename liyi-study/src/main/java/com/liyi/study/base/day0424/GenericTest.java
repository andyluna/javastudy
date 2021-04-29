package com.liyi.study.base.day0424;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 12:27  星期六
 */
public class GenericTest {

    @Test
    public void test1(){
        ArrayList list=new ArrayList();

        list.add(75);
        list.add(77);
        list.add(71);
        list.add(73);
        list.add(77);

//        list.add("Tom");

        for(Object obj:list){
//            System.out.println(obj);

            int stuScore=(Integer) obj;
        }

    }


    @Test
    public void test2(){
        ArrayList<Integer> list=new ArrayList<Integer>();

        list.add(45);
        list.add(44);
        list.add(78);
        list.add(65);


    }
}
