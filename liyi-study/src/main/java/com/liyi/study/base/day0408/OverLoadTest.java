package com.liyi.study.base.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 20:36  星期四
 */
public class OverLoadTest {

    //方法的重载
//    public void getSum(int i,int j){
//        System.out.println(i+j);
//    }
//
//    public void getSum(double d1,double d2){
//
//    }
//
//    public void getSum(String s,int i){
//
//    }
//
//    public void getSum(int i,String s){
//
//    }


    public void mOl(int i){
        System.out.println(i*i);
    }

    public void mOl(int i,int j){
        System.out.println(i*j);
    }

    public void mOl(String s){
        System.out.println(s);
    }



    public int max(int i,int j){
        return (i>j)?i:j;
    }

    public double max(double b1,double b2){
        return (b1>b2)?b1:b2;
    }

    public double max(double b1,double b2,double b3){

        double max=(b1>b2)?b1:b2;
        return (max>b3)?max:b3;

    }


}
