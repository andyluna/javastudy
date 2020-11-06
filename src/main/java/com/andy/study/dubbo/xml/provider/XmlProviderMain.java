package com.andy.study.dubbo.xml.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @time: 2020/11/4 十一月 22:03
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class XmlProviderMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/xml/provider.xml");

        context.start();

        System.in.read();
    }

}
