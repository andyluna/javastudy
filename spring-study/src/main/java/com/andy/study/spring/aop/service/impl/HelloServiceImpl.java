package com.andy.study.spring.aop.service.impl;

import com.andy.study.spring.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;

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
        log.debug("你好:{}",name);
        return "hello:"+name;
    }

    @Override
    public String toString() {
        return "HelloServiceImpl{" +
                "a='" + a + '\'' +
                '}';
    }
}
