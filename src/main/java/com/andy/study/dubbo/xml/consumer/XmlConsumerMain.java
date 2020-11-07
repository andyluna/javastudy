package com.andy.study.dubbo.xml.consumer;

import com.andy.study.dubbo.xml.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @time: 2020/11/6 十一月 14:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class XmlConsumerMain {

    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(1);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/xml/consumer.xml");
        context.start();

        HelloService helloService = context.getBean("helloService", HelloService.class);
        String hello = helloService.sayHello("你好啊");

        System.out.println(hello);

        System.out.println(helloService.now());
        System.out.println(helloService.saveUser("xiangdan2", 12));
        System.out.println(helloService.getUserVOById(1));
        System.out.println(helloService.getAllUsers());
        //cdl.wait();
    }


}
