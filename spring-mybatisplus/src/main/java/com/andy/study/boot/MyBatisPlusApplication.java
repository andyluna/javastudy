package com.andy.study.boot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @time: 2021/1/19 一月 16:08
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@MapperScan("com.andy.study.boot.mapper")
@Slf4j
public class MyBatisPlusApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyBatisPlusApplication.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (int i=0;i<names.length;i++){
            log.debug("{}.{}={}",i+1, names[i],context.getBean(names[i]));
        }


    }
}
