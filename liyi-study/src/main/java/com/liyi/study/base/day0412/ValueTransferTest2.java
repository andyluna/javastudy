package com.liyi.study.base.day0412;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 15:08  星期一
 */
public class ValueTransferTest2 {
    public static void main(String[] args) {

        Data data=new Data();
        data.m=10;
        data.n=20;
        System.out.println("m="+data.m+",n="+data.n);

        //交换mn的值
//        int temp=data.m;
//        data.m= data.n;
//        data.n=temp;


        ValueTransferTest2 test2=new ValueTransferTest2();
        test2.swap(data);

        System.out.println("m="+data.m+",n="+data.n);






    }

    public void swap(Data data){
        int temp=data.m;
        data.m= data.n;
        data.n=temp;

    }
}

class Data{

    int m;
    int n;


        }
