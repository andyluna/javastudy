package com.liyi.study.base.day0424;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 11:35  星期六
 */
public class CollectionsTest {

    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(158);
        list.add(456);
        list.add(456);
        list.add("ewe");

        System.out.println(list);
        //反转
//        Collections.reverse(list);
        //随机化
//        Collections.shuffle(list);
        //自然排序
//        Collections.sort(list);
        //交换指定索引的值
//        Collections.swap(list,1,2);
        //获取指定值出现的次数
        int frequency=Collections.frequency(list,456);

        System.out.println(list);
        System.out.println(frequency);
    }

    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(158);
        list.add(456);
        list.add(456);
        list.add("ewe");

        //抛异常
//        List dest=new ArrayList();
//        Collections.copy(dest,list);

        Object[] array;
        //创建一个与list集合长度相同的数组并转换成dest集合
        List dest= Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);

        System.out.println(list);


        List list1 = Collections.synchronizedList(list);
    }
}
