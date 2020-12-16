package com.andy.study.spring.xml;

import com.andy.study.spring.xml.ext.MyClasspathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2020/11/20 十一月 13:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Bean07Test {
    private static Logger logger = LoggerFactory.getLogger(Bean07Test.class);

    public static void main(String[] args) {

        MyClasspathXmlApplicationContext context = new MyClasspathXmlApplicationContext("bean07.xml");
        logger.info("启动完成 总共有 {} 个bean", context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            Object bean = context.getBean(names[i]);
            logger.info("{}.{} {} = {}", i + 1, names[i], bean.getClass(), bean);
        }


        context.registerShutdownHook();

    }

}
