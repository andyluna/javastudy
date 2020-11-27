package com.andy.study.spring.annotation;

import com.andy.study.spring.annotation.config.Config01;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/11/24 0:07  星期二
 */
@Slf4j
public class Anno01Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config01.class);
        log.info("启动完成 总共有 {} 个bean",context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
        }

        Environment bean = context.getBean(Environment.class);
        System.out.println(bean);

    }

}
