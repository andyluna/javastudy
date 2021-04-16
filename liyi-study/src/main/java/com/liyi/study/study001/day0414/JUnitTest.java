package com.liyi.study.study001.day0414;

import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 21:43  星期三
 */

public class JUnitTest {

    int num=10;
    @Test
    public void testEquals(){

        String s1="MM";
        String s2="MM";
        System.out.println(s1.equals(s2));

        System.out.println(num);
        show();
    }

    public void show(){
        num=20;
        System.out.println("show()...");
    }

}
