package com.liyi.study.base.day0422;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 20:18  星期四
 */
public class CompareTest {

    @Test
    public void test1(){
        String[] arr=new String[]{"AA","CC","KK","DD","FF","JJ"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("LenovoMouse",34);
        arr[1]=new Goods("DellMouse",43);
        arr[2]=new Goods("XiaomiMouse",12);
        arr[3]=new Goods("HuaweiMouse",65);
        arr[4]=new Goods("AiMouse",43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test3(){

        String[] arr=new String[]{"AA","CC","BB","kk","FF"};
        Arrays.sort(arr,new Comparator(){
            public int compare(Object o1,Object o2){
                if (o1 instanceof String&&o2 instanceof String){
                    String s1=(String) o1;
                    String s2=(String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
