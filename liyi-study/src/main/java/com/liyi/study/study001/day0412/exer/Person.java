package com.liyi.study.study001.day0412.exer;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 18:20  星期一
 */
public class Person {

    private int age;

    public void setAge(int a){
        if(a<0||a>130){
            System.out.println("传入的数据非法");
            return;
        }
        age=a;
    }

    public int getAge(){
        return age;
    }
}
