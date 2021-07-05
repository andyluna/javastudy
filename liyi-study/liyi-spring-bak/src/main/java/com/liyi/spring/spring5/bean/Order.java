package com.liyi.spring.spring5.bean;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 19:37  星期四
 */
public class Order {

    private String oname;

    //显示写出无参构造器
    public Order() {
        System.out.println("1.执行了Order的无参构造器,创建Order实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2.调用set方法设置属性值");
    }

    //创建执行的初始化的方法
    public void initMethod(){
        System.out.println("3.执行初始化的方法");
    }

    //创建执行的销毁的方法
    public void destroyMethod(){
        System.out.println("5.执行销毁的方法");
    }

}
