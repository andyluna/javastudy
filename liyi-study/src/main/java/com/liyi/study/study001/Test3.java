package com.liyi.study.study001;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/2 17:11  星期五
 */

import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {


    //位运算符
    //<< ：在一定范围内，每向左移一位，相当于*2
    //>> : 在一定范围内，每向右移一位，相当于/2

  /*  int num1=2*8;
    int num2=2<<3;
    int num3=8<<1;

    System.out.println(num1+","+num2+","+num3);

   */

        Scanner scan=new Scanner(System.in);

      /*
        System.out.println("请输入你的姓名：");
        String name=scan.next();
        System.out.println(name);

        System.out.println("请输入你的年龄：");
        int age=scan.nextInt();
        System.out.println(age);

        System.out.println("请输入你的体重：");
        double weight=scan.nextDouble();
        System.out.println(weight);

        System.out.println("你是否相中我了？（true/false）");
        boolean isLove=scan.nextBoolean();
        System.out.println(isLove);

        //对于char型,Scanner没有提供相关的方法，只能获取一个字符串;
        System.out.println("请输入你的性别：（男/女）");
        String gender=scan.next();
        System.out.println(gender);
        char genderChar=gender.charAt(0);
        System.out.println(genderChar);

       */


        /*
        System.out.println("请输入岳小鹏的期末成绩：（0-99）");
        int score=scan.nextInt();

        if(score==100){
            System.out.println("奖励一台BYD");
        }else if (score>80&&score<=99){
            System.out.println("奖励一台Iphone");
        }else if (score>60&&score<=80) {
            System.out.println("奖励一台Ipad");
        }else{
            System.out.println("奖励一个大嘴巴子");
        }
        //else不是必要结构
         */

        /*
        System.out.println("请输入季节：");
        String season=scan.next();

        switch (season){
            case "spring":
                System.out.println("春暖花开");
                break;
            case "summer":
                System.out.println("夏日炎炎");
                break;
            case "autumn":
                System.out.println("秋高气爽");
                break;
            case "winter":
                System.out.println("冬雪皑皑");
                break;
            default:
                System.out.println("季节输入有误");
                break;
                //break关键字是可选的；default结构是可选的，且位置是灵活的
        }
         */


      /*
        System.out.println("请输入年：");
        int year=scan.nextInt();
        System.out.println("请输入月：");
        int month=scan.nextInt();
        System.out.println("请输入日：");
        int day=scan.nextInt();

        int sumday=0;

        switch (month){
            case 12:
                sumday+=30;
            case 11:
                sumday+=31;
            case 10:
                sumday+=30;
            case 9:
                sumday+=31;
            case 8:
                sumday+=31;
            case 7:
                sumday+=30;
            case 6:
                sumday+=31;
            case 5:
                sumday+=30;
            case 4:
                sumday+=31;
            case 3:
                if ((year%4==0&&year%100!=0)||year%400==0){
                    sumday+=29;
                }else{
                    sumday+=28;
                }
            case 2:
                sumday+=31;
            case 1:
                sumday+=day;
        }
        System.out.println(year+"年"+month+"月"+day+"日是当年的第"+sumday+"天");

       */

        for (int i=1;i<=100;i++){
            System.out.println("你好"+i);
        }

        //遍历100以内的偶数,输出所有偶数的和
        int sum=0;
        int count=0;
        for (int i=1;i<=100;i++){
            if (i%2==0){
                System.out.println(i);
                sum+=i;
                count++;
            }
        }
        System.out.println("总和为"+sum);
        System.out.println("偶数个数为"+count);




    }





}
