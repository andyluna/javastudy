package com.andy.study.spring.aop.service.impl;

import com.andy.study.spring.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/24 十一月 22:46
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Slf4j
public class HelloServiceImpl implements HelloService {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String sayHello(String name) {
        log.debug("你好:{}", name);
        //LocalDateTime nowDate = getNowDate(name);
        LocalDateTime nowDate1 = ((HelloService) AopContext.currentProxy()).getNowDate(name);

        return "hello:" + name + nowDate1;
    }

    @Override
    public LocalDateTime getNowDate(String name) {
        log.debug("获取当前时间参数{}" + name);
        LocalDateTime now = LocalDateTime.now();
        log.debug("当前时间:{}", now);
        return now;
    }

    @Override
    public String toString() {
        return "HelloServiceImpl{" +
                "a='" + a + '\'' +
                '}';
    }
}
