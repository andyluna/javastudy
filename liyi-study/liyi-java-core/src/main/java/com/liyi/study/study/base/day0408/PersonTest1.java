package com.liyi.study.study.base.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 17:54  星期四
 */
public class PersonTest1 {
    public static void main(String[] args) {
        Person p=new Person();

        p.name="Tom";
        p.age=18;
        p.sex=1;

        p.study();
        p.showAge();

        int newAge=p.addAge(2);
        System.out.println(p.name+"的新年龄为："+newAge);
        System.out.println(p.age);//20


        Person p1=new Person();
        p.showAge();


    }
}
