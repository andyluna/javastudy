package com.liyi.study.study001;

import java.util.Scanner;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/6 17:43  星期二
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
      /*
        System.out.println("请输入第一个正整数：");//10
        int m=scan.nextInt();
        System.out.println("请输入第二个正整数：");//20
        int n=scan.nextInt();

        int min=(m<=n)?m:n;
        for (int i=min;i>=1;i--){
            if(m%i==0&&n%i==0){
                System.out.println("最大公约数为："+i);
                break;
            }
        }


        int max=(m>=n)?m:n;
        for (int i=max;i<=m*n;i++){
            if(i%m==0&&i%n==0){
                System.out.println("最小公倍数为："+i);
                break;
            }
        }

       */

        /*
        int num=1;
        int sum=0;//总和
        int count=0;//个数

        do {

            if(num%2==0){
                System.out.println(num);
                sum+=num;
                count++;
            }
            num++;
        }while (
                num<=100
        );
        System.out.println("总和为："+sum);
        System.out.println("个数为："+count);

         */

      /*
        //循环嵌套
        for (int j=1;j<=4;j++){
            for (int i=1;i<=6;i++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+(i*j)+"  ");
            }
            System.out.println();
        }

        boolean isFlag=true;//表示i是否被j除尽。除尽就修改值

        for (int i=2;j<=100;i++){//遍历100以内的自然数
            for (int j=2;j<i;j++){//j被i去除
                if(i%j==0){//i被j除尽
                    isFlag=false;
                }
            }
            if (isFlag==true){
                System.out.println(i);
                break;
            }
            //重置isFlag
            isFlag=true;
        }

       */














    }
}
