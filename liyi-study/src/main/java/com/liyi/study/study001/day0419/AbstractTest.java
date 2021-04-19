package com.liyi.study.study001.day0417;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/17 20:45  星期六
 */
public class AbstractTest {
    public static void main(String[] args) {
        //一旦抽象了，就不可以实例化
//        Person p1=new Person();
    }


}

abstract class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("人吃饭");
    }
    public void walk(){
        System.out.println("人走路");
    }

}


 class Student extends Person{

    public Student(String name,int age){
        super(name,age);
    }

//    public void eat(){
//        System.out.println("学生应该多吃有营养的食物");
//    }
}
