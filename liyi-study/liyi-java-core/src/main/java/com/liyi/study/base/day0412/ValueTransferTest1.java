package com.liyi.study.base.day0412;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 14:06  星期一
 *
 */
public class ValueTransferTest1 {

    public static void main(String[] args) {
        int m=10;
        int n=20;

        System.out.println("m="+m+",n="+n);//10 20

        ValueTransferTest1 test1=new ValueTransferTest1();
        test1.swap(m,n);


        System.out.println("m="+m+",n="+n);//10  20
    }

    public void swap(int m,int n){
        int temp=m;
        m=n;
        n=temp;
       //System.out.println("m="+m+",n="+n);

    }

}
