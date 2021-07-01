package com.andy.test;

import com.liyi.spring.spring5.config.SpringConfig;
import com.liyi.spring.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 20:41  星期四
 */
public class MyTest3 {

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean9.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void test2(){//测试完全注解
        //加载配置类
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }
}
