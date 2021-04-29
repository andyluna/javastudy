package com.liyi.study.base.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 18:42  星期四
 */
public class Student {
    int number;//学号
    int state;//年级
    int score;//成绩


    //显示学生信息的方法
    public String info(){
        return "学号："+","+number+"年级："+state+","+"成绩："+score;
    }

}
