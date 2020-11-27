package com.andy.study.spring.aop;

import com.andy.study.spring.aop.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @time: 2020/11/24 十一月 22:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AopXmlTest01 {
    private static final Logger log = LoggerFactory.getLogger(AopXmlTest01.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop/aop01.xml");
        log.info("启动完成 总共有 {} 个bean",context.getBeanDefinitionCount());

        HelloService hs = context.getBean("helloService",HelloService.class);
        for (int i = 1; i < 6; i++) {
            String res = hs.sayHello("andy"+i);
            log.debug("第 {} 返回结果 - {}",i,res);
        }

        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
        }


        context.registerShutdownHook();
    }
}
