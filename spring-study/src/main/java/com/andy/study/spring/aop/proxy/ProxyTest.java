package com.andy.study.spring.aop.proxy;

import com.andy.study.spring.aop.proxy.advisor.MyAdvisor;
import com.andy.study.spring.aop.proxy.aspect.MyAspect01;
import com.andy.study.spring.aop.proxy.aspect.MyAspect02;
import com.andy.study.spring.aop.proxy.interceptor.DebugInterceptor;
import com.andy.study.spring.aop.proxy.service.T1;
import com.andy.study.spring.aop.proxy.service.advice.RetryAdvice;
import com.andy.study.spring.aop.proxy.service.impl.T1Impl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;

/**
 * @time: 2020/11/28 十一月 12:23
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class ProxyTest {

    @Test
    public void test01(){
        T1 t = new T1Impl();

        t.foo();
    }

    @Test
    public void test02(){
        T1 t = new T1Impl();
        t.foo();
        log.debug("普通方法执行结束");
        ProxyFactory factory = new ProxyFactory(t);
        factory.addInterface(T1.class);
        factory.addAdvice(new RetryAdvice());

        factory.addAdvisor(new MyAdvisor());

        factory.setExposeProxy(true);
        T1 t1Proxy = (T1) factory.getProxy();
        t1Proxy.foo();
    }

    @Test
    public void test03(){
        T1 t = new T1Impl();
        t.foo();
        log.debug("普通方法执行结束");

        AspectJProxyFactory factory = new AspectJProxyFactory(t);
        factory.addInterface(T1.class);


        factory.addAspect(MyAspect01.class);
        factory.addAdvice(new RetryAdvice());
        factory.addAspect(MyAspect02.class);
        factory.addAdvice(new PerformanceMonitorInterceptor());
        factory.addAdvice(new DebugInterceptor());
        factory.setExposeProxy(true);



        T1 t1Proxy = (T1) factory.getProxy();
        t1Proxy.foo();
    }


}
