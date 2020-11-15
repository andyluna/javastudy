package com.andy.study.jvm.dynimic;

/**
 * @time: 2020/10/24 十月 16:07
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class RealSubject implements Subject {

    @Override
    public String request(String name) {

        System.out.println("RealSubject "+name);
        return "realSubject"+name;
    }
}
