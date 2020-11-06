package com.andy.study.dubbo.simple.consumer;

import com.andy.study.dubbo.simple.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @time: 2020/11/4 十一月 20:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SimpleConsumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/simple/consumer.xml");
        context.start();
        DemoService demoService = context.getBean(DemoService.class);
        String andy = demoService.sayHello("andy");
        System.out.println(andy);

        System.in.read();
    }
}
