package com.andy.study.boot;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

/**
 * @time: 2021/1/21 一月 10:45
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class StringUtilTest {

    @Test
    public void test1(){
        String s = " a ,b";
        String[] array = StringUtils.delimitedListToStringArray(s, ",");
        System.out.println(array.length);
        for(String r:array){
            System.out.println("字符串="+r);
        }
    }

    @Test
    public void test2(){
        String s = " a ,b ,,, c";
        String[] array = StringUtils.tokenizeToStringArray(s, ",");
        System.out.println(array.length);
        for(String r:array){
            System.out.println("字符串="+r);
        }
        String s1 = StringUtils.arrayToCommaDelimitedString(array);
        System.out.println(s1);
    }

    @Test
    public void test3(){
        String s = " a ,b";

        String[] array = StringUtils.commaDelimitedListToStringArray(s);
        System.out.println(array.length);
        for(String r:array){
            System.out.println("字符串="+r);
        }

        String s1 = StringUtils.arrayToCommaDelimitedString(array);
        System.out.println(s1);
    }
}
