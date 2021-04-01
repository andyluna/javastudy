package com.liyi.study.study001;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/1 15:30  星期四
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test2=new Test1();

        int num1=12;
        int num2=5;
        int result1=num1/num2;//2

        System.out.println(result1);


        int result2=num1/num2*num2;
        System.out.println(result2);//10

        double result3=num1/num2;//2.0
        double result4=num1/num2+0.0;//2.0
        double result5=num1/(num2+0.0);//2.4
        double result6=(double)num1/num2;//2.4
        double result7=(double)(num1/num2);//2.0
        System.out.println(result7);



        //前++:先自增1.然后再运算
        //后++:先运算，后自增1
        int a1=10;
        int b1 = ++a1;
        System.out.println(a1+","+b1);//11 11

        int a2=10;
        int b2=a2++;
        System.out.println(a2+","+b2);//11 10

        int a3=10;
        //++a3;
        a3++;
        int b3=a3;
        System.out.println(a3+","+b3);//11 11    //11 11

        short s1=10;
        s1++;
        System.out.println(s1);//11  自增1不会改变本身变量的数据类型

        byte bb1=127;
        bb1++;
        System.out.println(bb1);//-128


        //前--:先自减1，后运算
        //后--:先运算，后自减1
        int aa1=10;
        int bb2=--aa1;//int bb2=aa1--;
        System.out.println(aa1+","+bb2);

    }


}
