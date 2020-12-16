package com.andy.study.jvm.str;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/4 16:25  星期日
 */
public class StringTest {


    public static void main(String[] args) {

        test1();

    }

    public static void test() {
        System.out.println();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");

        System.out.println();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");
    }

    public static void test1() {
        String s = new String("1");
        s = s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("2") + new String("3");


        System.out.println(s3.hashCode());
        String s6 = s3.intern();
        System.out.println(s3.hashCode());
        System.out.println(s6.hashCode());
        String s4 = "23";
        System.out.println(s4.hashCode());

        System.out.println(s3 == s4);


    }

}
