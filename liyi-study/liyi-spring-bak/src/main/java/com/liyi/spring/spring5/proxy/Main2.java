package com.liyi.spring.spring5.proxy;

import com.liyi.spring.spring5.proxy.impl.MaopiaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 23:28  星期日
 */
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext ac1 = new AnnotationConfigApplicationContext();
//        ApplicationContext ac = new ClassPathXmlApplicationContext("aop/bean-aop01.xml");
//        Maipiao maipiao = ac.getBean("maipiao", Maipiao.class);
//        String s1 = maipiao.train1();
//        System.out.println("火车票 = "+s1);
//
//
//        System.out.println("--------------------------------------------------");
//        String s = maipiao.fly1();
//        System.out.println("飞机票 = "+s );
    }
}
