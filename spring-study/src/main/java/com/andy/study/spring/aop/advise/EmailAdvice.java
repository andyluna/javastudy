package com.andy.study.spring.aop.advise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @time: 2020/11/24 十一月 23:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class EmailAdvice implements MethodBeforeAdvice, AfterReturningAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.debug("方法执行之前 发送邮件 {} ,{}", method, args);
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.debug("方法执行之后 返回结果 发送邮件:{}", returnValue);
    }
}
