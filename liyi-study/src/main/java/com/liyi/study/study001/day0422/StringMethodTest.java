package com.liyi.study.study001.day0422;

import org.junit.Test;

import java.util.Locale;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 12:22  星期四
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1="HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        System.out.println(s1.isEmpty());

        String s2=s1.toLowerCase(Locale.ROOT);//转换成小写
        System.out.println(s1);
        System.out.println(s2);

        String s3="   he  llo  world   ";
        String s4=s3.trim();
        System.out.println("----"+s3+"----");
        System.out.println("----"+s4+"----");
    }


    @Test
    public void test2(){

        String s1="HelloWorld";
        String s2="helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写比较


        String s3="abc";
        String s4="abe";
        System.out.println(s3.compareTo(s4));//涉及到字符串排序

        String s5="湖南长沙天心区";
        String s6=s5.substring(2);
        System.out.println(s6);
        String s7=s5.substring(2,4);
        System.out.println(s7);
    }

    @Test
    public void test3(){

        String str1="helloworld";
        boolean b1=str1.endsWith("d");
        boolean b2=str1.endsWith("rld");
        System.out.println(b1);
        System.out.println(b2);

        boolean b3=str1.startsWith("HE");//字符开始是否有指定字符
        boolean b4=str1.startsWith("ll",2);//从索引位置开始
        System.out.println(b3);
        System.out.println(b4);

        String str2="wo";
        System.out.println(str1.contains(str2));//判断是否包含

        System.out.println(str1.indexOf("lo"));//3
        System.out.println(str1.indexOf("lol"));//-1 没找到
        System.out.println(str1.indexOf("lo",5));

        String str3="hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.indexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));
    }

    @Test
    public void test4(){
        String str1="湖湖南长沙天心湖南";
        String str2=str1.replace("南","北");//更改所有
        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str1.replace("湖南","河北"));
    }

}
