package com.andy.study.jvm.bytecode;

/**
 * @time: 2020/10/24 十月 11:22
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BCTest2 {

    String str = "xiangdan";

    public int a = 4;

    private static String str2 = "asd3";

    public static void main(String[] args) {
        BCTest2 bc = new BCTest2();

        bc.a = 3;
        bc.str2 = "1233";
    }

    private synchronized void setStr(String str) {
        this.str = str;
    }

}
