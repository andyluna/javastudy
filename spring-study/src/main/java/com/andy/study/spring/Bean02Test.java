package com.andy.study.spring;

import com.andy.study.spring.di.Command;
import com.andy.study.spring.di.CommandManager;
import com.andy.study.spring.ext.MyClasspathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @time: 2020/11/20 十一月 13:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Bean02Test {
    private static  Logger logger = LoggerFactory.getLogger(Bean02Test.class);
    public static void main(String[] args) {

        MyClasspathXmlApplicationContext context = new MyClasspathXmlApplicationContext("bean02.xml");

        logger.info("启动完成 总共有 {} 个bean",context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
        }

        context.registerShutdownHook();

    }
}
