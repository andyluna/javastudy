package com.liyi.study.base.day0422;

import org.junit.Test;

import java.util.Arrays;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 13:34  星期四
 */
public class StringTest1 {
    @Test
    public void test1(){
        String str1="123";
        int num=Integer.parseInt(str1);

        String str2=String.valueOf(num);//"123"
        String str3=num+"";
        System.out.println(str1==str3);
    }

    @Test
    public void test2(){
        String str1="abc123";
        char[] chars=str1.toCharArray();
        for (int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }


        char[] arr=new char[]{'a','b','c','1','2','3'};
        String str2=new String(arr);
        System.out.println(str2);
    }


    @Test
    public void test3(){
        String str1="abc123";
        byte[] bytes=str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String str2=new String(bytes);
        System.out.println(str2);
    }
}
