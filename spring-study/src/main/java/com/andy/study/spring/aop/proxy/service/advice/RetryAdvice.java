package com.andy.study.spring.aop.proxy.service.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @time: 2020/11/28 十一月 12:31
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class RetryAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.debug("切面进来了:{}",method);
    }
}
