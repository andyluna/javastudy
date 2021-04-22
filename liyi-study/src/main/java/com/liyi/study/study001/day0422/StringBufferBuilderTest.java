package com.liyi.study.study001.day0422;

import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 14:04  星期四
 */
public class StringBufferBuilderTest {

    @Test
    public void test1(){
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

    }

    @Test
    public void test2(){
        StringBuffer s1=new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        System.out.println(s1);
//        s1.delete(2,4);
//        s1.replace(2,4,"123");
//        s1.insert(2,false);
//        s1.reverse();
        String s2=s1.substring(1,3);
        System.out.println(s1);
        System.out.println(s2);



    }

}
