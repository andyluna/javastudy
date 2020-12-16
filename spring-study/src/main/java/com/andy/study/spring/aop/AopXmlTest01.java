package com.andy.study.spring.aop;

import com.andy.study.spring.aop.service.HelloService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/24 十一月 22:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AopXmlTest01 {
    private static final Logger log = LoggerFactory.getLogger(AopXmlTest01.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop/aop01.xml");
        log.info("启动完成 总共有 {} 个bean", context.getBeanDefinitionCount());

        HelloService hs = context.getBean("helloService", HelloService.class);

        LocalDateTime date = hs.getNowDate("xiangdan");

        String res = hs.sayHello("andy1");

//
//        for (int i = 1; i < 6; i++) {
//            String res = hs.sayHello("andy"+i);
//            log.debug("第 {} 返回结果 - {}",i,res);
//        }
//
//        String[] names = context.getBeanDefinitionNames();
//        for (int i = 0; i < names.length; i++) {
//            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
//        }


        context.registerShutdownHook();
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getBeanFactory();


        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        builder.setLazyInit(false);
        builder.getRawBeanDefinition().setBeanClassName("com.andy.study.spring.aop.service.impl.HelloServiceImpl");
        //builder.getRawBeanDefinition().setBeanClass(Car.class);
        builder.addPropertyValue("a", "nihao");
        //builder.setAbstract(true);
        AbstractBeanDefinition definition = builder.getBeanDefinition();


        registry.registerBeanDefinition("xiangdan", definition);
        context.refresh();
        log.info("启动完成 总共有 {} 个bean", context.getBeanDefinitionCount());

        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n", i + 1, names[i], context.getBean(names[i]));
        }
        context.registerShutdownHook();
    }


}
