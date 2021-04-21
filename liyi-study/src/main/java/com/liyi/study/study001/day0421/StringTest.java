package com.liyi.study.study001.day0421;

import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/21 21:44  星期三
 */
public class StringTest {

    @Test
    public void test1(){
        String s1="abc";
        String s2="abc";

        s1="123";

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        String s3="abc";
        s3+="def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        String s4="abc";
        String s5=s4.replace('a','m');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc



    }

    @Test
    public void test2(){
//        String s1="abc";
//        String s2="abc";

        String s3=new String("abc");
//        String s4=new String("abc");

//        System.out.println(s1==s2);//ture
//        System.out.println(s1==s3);//false
//        System.out.println(s3==s4);//false
//        System.out.println(s1==s4);//false

        s3="ccc";
        System.out.println(s3);

    }

    @Test
    public void test3(){

        String s1="javaEE";
        String s2="hadoop";

        String s3="javaEEhadoop";
        String s4="javaee"+"hadoop";
        String s5=s1+"hadoop";
        String s6="javaEE"+s2;
        String s7=s1+s2;

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        System.out.println(s3==s7);
        System.out.println(s5==s6);
        System.out.println(s6==s7);
        System.out.println(s5==s7);

        String s8=s5.intern();//返回值得到的s8使用的常量池已经存在的“javaEEhadoop”
        System.out.println(s3==s8);

    }



    String str=new String("good");
    char[] ch={'t','e','s','t'};

    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringTest ex=new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }


}
