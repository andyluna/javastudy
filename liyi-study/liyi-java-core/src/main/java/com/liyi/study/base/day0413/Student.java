package com.liyi.study.base.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 15:30  星期二
 */
public class Student extends Person{
    String major;

    public Student(){

    }
    public Student(String major){
        this.major=major;
    }

    public void study(){
        System.out.println("学习。专业是:"+major);
    }

    //对父类中的eat方法进行重写
    public void eat(){
        System.out.println("学生应该多吃有营养的食物");
    }
}
