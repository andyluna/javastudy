package com.liyi.study.study001.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 16:47  星期四
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cust=new Customer();
        cust.eat();


        cust.sleep(8);

    }




}

//客户类
class Customer{
    //属性
    String name;
    int age;
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("客户吃饭");
    }
    public void sleep(int hour){
        System.out.println("休息了"+hour+"个小时");
        eat();
    }
    public String getName(){
        return name;
    }
    public String getNation(String nation){
        String info="我的国籍是"+nation;
        return info;
    }



}
