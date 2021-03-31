package com.liyi.study.study001;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/3/30 23:08  星期二
 */
public class HelloWorld {

    public static void main(String[] args) {
        for (int i = 0; i < 65535; i++) {

            System.out.print(i+" = "+(char)i+" \n");

        }


    }




    public static void test1(){
        char c1='a';
        int i1=10;
        int i2=c1+i1;
        System.out.println(i2);

        byte a=12;
        double b=a+12.3;
        int c=a+(int)b;
        System.out.println(c);
    }
}
