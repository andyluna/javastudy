package com.andy.study.spring.xml;

import com.andy.study.spring.xml.ext.MyClasspathXmlApplicationContext;
import com.andy.study.spring.xml.factoryPostProcessor.MyBeanFactory001PostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2020/11/20 十一月 13:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Bean02Test {
    private static Logger logger = LoggerFactory.getLogger(Bean02Test.class);

    public static void main(String[] args) {

        MyClasspathXmlApplicationContext context = new MyClasspathXmlApplicationContext(new String[]{"bean02.xml"}, false);
        context.addBeanFactoryPostProcessor(new MyBeanFactory001PostProcessor());
        context.refresh();
        logger.info("启动完成 总共有 {} 个bean", context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n", i + 1, names[i], context.getBean(names[i]));
        }

        context.registerShutdownHook();

    }
}
