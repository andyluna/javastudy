package com.andy.study.jvm.bytecode;

/**
 * @time: 2020/10/24 十月 16:01
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BCTest5 {

    public static void main(String[] args) {

    }

    public int sub(){
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int n = (a+b+c)-d;

        return n;
    }
}
