package com.andy.study.spring.aop.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @time: 2020/11/28 十一月 12:36
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@Aspect
public class MyAspect02 {
    public MyAspect02() {
        log.debug("MyAspect02初始化");
    }

    @Before("com.andy.study.spring.aop.proxy.aspect.MyAspect01.pc()")
    public void hello2(JoinPoint jp) {
        log.debug("hello2 - {} - {}", jp.getClass(), jp);
        MethodInvocationProceedingJoinPoint mejp = (MethodInvocationProceedingJoinPoint) jp;
    }
}
