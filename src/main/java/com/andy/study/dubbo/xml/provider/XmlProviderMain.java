package com.andy.study.dubbo.xml.provider;

import com.andy.study.dubbo.embedded.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @time: 2020/11/4 十一月 22:03
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class XmlProviderMain {

    public static void main(String[] args) throws Exception {

//        new EmbeddedZookeeper(2182, false).start();
//        Thread.sleep(1000);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/xml/provider.xml");

        context.start();

        System.in.read();
    }

}
