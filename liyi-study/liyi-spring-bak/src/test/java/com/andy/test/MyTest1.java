package com.andy.test;

import com.liyi.spring.spring5.Book;
import com.liyi.spring.spring5.Order;
import com.liyi.spring.spring5.aop.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 0:12  星期四
 */
public class MyTest1 {

    @Test
    public void test1(){
        //加载spring配置文件
        AbstractApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");
        System.out.println(System.currentTimeMillis());

        //获取配置创建的对象
        Book book = context.getBean( Book.class);
        System.out.println(book);
        //获取配置创建的对象
        Book book2 = context.getBean( "book2",Book.class);
        System.out.println(book2);

        context.registerShutdownHook();
        //获取配置创建的对象
//        Book book2 = context.getBean("book2",Book.class);
//        System.out.println(book);
    }

    @Test
    public void test2(){
        //加载spring配置文件
        ApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");

        //获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void test3(){
        //加载spring配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void test4(){
        //加载spring配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Order order = context.getBean("orders", Order.class);
        System.out.println(order);
        order.orderTest();
    }



}
