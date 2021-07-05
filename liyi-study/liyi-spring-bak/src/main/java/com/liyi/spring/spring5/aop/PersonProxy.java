package com.liyi.spring.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/2 11:16  星期五
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.liyi.spring.spring5.aop.User.add(..))")
    public void afterReturning(){
        System.out.println("Person Before......");
    }
}
