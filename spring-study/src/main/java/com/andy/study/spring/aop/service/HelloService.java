package com.andy.study.spring.aop.service;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/24 十一月 22:45
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface HelloService {

    String sayHello(String name);


    LocalDateTime getNowDate(String name);
}
