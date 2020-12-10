package com.andy.study.spring.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @time: 2020/12/4 十二月 21:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ProfileXmlTest001 {
    private static final Logger log = LoggerFactory.getLogger(ProfileXmlTest001.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocations("profile/profile01.xml");
        context.getEnvironment().addActiveProfile("dev");
        context.refresh();
        String[] names = context.getBeanDefinitionNames();
        log.debug("总共初始化了 {} 个bean",names.length);
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
        }
    }
}
