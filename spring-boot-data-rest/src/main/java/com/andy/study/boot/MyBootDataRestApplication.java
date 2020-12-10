package com.andy.study.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @time: 2020/11/29 十一月 15:08
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@EnableJpaAuditing
public class MyBootDataRestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyBootDataRestApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        Environment contextBean = context.getBean(Environment.class);


    }
}
