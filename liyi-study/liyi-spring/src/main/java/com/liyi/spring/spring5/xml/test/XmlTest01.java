package com.liyi.spring.spring5.xml.test;

import com.liyi.spring.spring5.xml.entity.Book;
import com.liyi.spring.spring5.xml.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 0:29  星期一
 */
public class XmlTest01 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("xml/bean-xml01.xml");
        Book book = ac.getBean("book", Book.class);
        System.out.println(book);

        Car car = ac.getBean("car", Car.class);
        System.out.println(car);

        Object o = ac.getBean("car1" );
        System.out.println(o.getClass()+" "+o);

        Object o1 = ac.getBean("&car1" );
        System.out.println(o1.getClass()+" "+o1);

    }
}
