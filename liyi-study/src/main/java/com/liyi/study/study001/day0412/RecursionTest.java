package com.liyi.study.study001.day0412;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 16:17  星期一
 */
public class RecursionTest {
    public static void main(String[] args) {
        //计算1-100所有自然数的和
//        int sum=0;
//        for (int i=1;i<=100;i++){
//            sum+=i;
//        }
    }

    public int getSum(int n){
        if(n==1){
            return 1;
        }else {
            return n+getSum(n-1);
        }
    }

}
