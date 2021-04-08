package com.liyi.study.study001.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 15:06  星期四
 */
public class PersonTest {
    public static void main(String[] args) {
        //创建Person类的对象
        Person p=new Person();

        //调用对象的属性、方法
        p.name="Tom";
        p.isMale=true;
        System.out.println(p.name);

        p.eat();
        p.sleep();
        p.talk("Chinese");

        //创建了一个类的多个对象，则每个对象都独立的拥有一套独立的属性（非static)
        //意味着如果我们修改一个对象的属性A,则不影响另一个对象属性A的值
        Person p1=new Person();
        System.out.println(p1.name);


    }






    static class Person{
        //属性
        String name;
        int age=1;
        boolean isMale;

        //方法
        public void eat(){
            System.out.println("人可以吃饭");
        }
        public void sleep(){
            System.out.println("人可以睡觉");
        }
        public void talk(String language){
            System.out.println("人可以说话，使用的是："+language);
        }
    }
}
