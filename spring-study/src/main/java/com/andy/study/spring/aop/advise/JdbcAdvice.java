package com.andy.study.spring.aop.advise;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @time: 2020/11/24 十一月 23:25
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class JdbcAdvice extends PerformanceMonitorInterceptor {


}
