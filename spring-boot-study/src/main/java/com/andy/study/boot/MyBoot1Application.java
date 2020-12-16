package com.andy.study.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @time: 2020/11/29 十一月 15:08
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@Slf4j
public class MyBoot1Application {

    public static void main(String[] args) throws IOException {
        //System.setProperty("spring.application.json", "{\"myname\":\"xiangdan向丹\"}");
        ConfigurableApplicationContext context = SpringApplication.run(MyBoot1Application.class, args);
        String[] name = context.getBeanDefinitionNames();
        log.debug("总共有{}", name.length);

        Arrays.sort(name);
        Stream.of(name).sorted().forEach(System.out::println);


        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getBeanFactory();
        String[] names = factory.getSingletonNames();
        System.out.println("---------------------------------");
        Arrays.sort(names);
        Stream.of(names).sorted().forEach(System.out::println);
        log.debug("总共有{}", names.length);
        for (int i = 0; i < names.length; i++) {
            Object bean = context.getBean(names[i]);
            System.out.println(names[i]);
            //log.debug("{}.{}={}  , {} ",(i+1),names[i],bean.getClass(),bean);
        }


        System.out.println("***************************");

        List<String> collect = Stream.of(names).filter(s ->
                !Stream.of(name).anyMatch(n -> n.equals(s))
        ).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            Object bean = context.getBean(collect.get(i));
            log.debug("{}.{}={}  , {} ", (i + 1), collect.get(i), bean.getClass(), bean);
        }
        System.out.println("***************************");
        for (int i = 0; i < names.length; i++) {
            String s = names[i];
            boolean b = Stream.of(name).anyMatch(t -> t.equals(s));
            if (!b) {
                System.out.println(s);
            }
        }


    }
}
