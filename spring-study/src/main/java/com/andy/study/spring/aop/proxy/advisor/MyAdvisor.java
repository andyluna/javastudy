package com.andy.study.spring.aop.proxy.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @time: 2020/11/28 十一月 13:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyAdvisor implements Advisor {

    private String someProperty;

    @Override
    public Advice getAdvice() {
        return new MyAdvice1();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    public static class MyAdvice1 implements MethodBeforeAdvice{

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("内部内 方法执行之前");
        }
    }
}
