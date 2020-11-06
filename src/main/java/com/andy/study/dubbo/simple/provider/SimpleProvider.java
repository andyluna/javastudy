package com.andy.study.dubbo.simple.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @time: 2020/11/4 十一月 20:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SimpleProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/simple/provider.xml");
        context.start();
        System.in.read(); // 按任意键退出

    }
}
