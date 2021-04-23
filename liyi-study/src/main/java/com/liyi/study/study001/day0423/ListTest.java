package com.liyi.study.study001.day0423;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 16:05  星期五
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",20));
        list.add("456");
        System.out.println(list);

        list.add(1,"BB");
        System.out.println(list);

        List integers = Arrays.asList(1, 2, 3);
        list.addAll(integers);
        System.out.println(list.size());

        System.out.println(list.get(1));



    }


    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",20));
        list.add("456");

        int index=list.indexOf("456");//找不到返回-1
        System.out.println(index);

        int index1=list.lastIndexOf(456);
        System.out.println(index1);

        Object obj=list.remove(1);
        System.out.println(obj);
        System.out.println(list);

        list.set(1,"CC");
        System.out.println(list);

        List sub=list.subList(2,4);
        System.out.println(sub);
        System.out.println(list);



    }
}
