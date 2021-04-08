package com.liyi.study.study001.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 10:28  星期四
 */
public class Person {

    String name;
    int age;
    int sex;

    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println("age:"+age);
    }

    public int addAge(int i){
        age+=i;
        return age;
    }
}
