package com.andy.study.spring.aop.proxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.util.Arrays;

/**
 * @time: 2020/11/28 十一月 12:36
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@Aspect
public class MyAspect01 {
    public MyAspect01() {
        log.debug("MyAspect01初始化");
    }
    @Pointcut("execution(* com.andy.study.spring.aop.proxy.service.impl.T1Impl.*(..))")
    public void pc(){

    }
    @Before("pc()")
    public void beforeLog(JoinPoint jp){
        log.debug("hello1 - {} - {}",jp.getClass(),jp);
        MethodInvocationProceedingJoinPoint mejp = (MethodInvocationProceedingJoinPoint) jp;
    }
}
