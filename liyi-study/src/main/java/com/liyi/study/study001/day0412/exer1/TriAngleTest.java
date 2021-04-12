package com.liyi.study.study001.day0412.exer1;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 18:56  星期一
 */
public class TriAngleTest {

    public static void main(String[] args) {
        TriAngle t1=new TriAngle();

        t1.setBase(2.0);
        t1.setHeight(2.4);
        System.out.println("base:"+t1.getBase()+",height:"+t1.getHeight());

        TriAngle t2=new TriAngle(5.1,5.6);
        System.out.println("base:"+t1.getBase()+",height:"+t1.getHeight());


    }
}
