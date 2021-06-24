package com.liyi.study.study.base.day0416;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/16 13:08  星期五
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese c1=new Chinese();
        c1.name="姚明";
        c1.age=40;
        c1.nation="CHN";

        Chinese c2=new Chinese();
        c2.name="马龙";
        c2.age=30;
        c2.nation="China";
        System.out.println(c1.nation);


    }
}


class Chinese{
    String name;
    int age;
    static String nation;



}
