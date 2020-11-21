package com.andy.study.spring.di;

import com.andy.study.spring.di.impl.AsyncCommand;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @time: 2020/11/20 十一月 23:15
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LookupOverrideMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 检测是否是需要override的方法（写的很简单，能说明问题即可，要那么复杂干嘛呢）
        if ("createCommand".equals(method.getName())) {
            return new AsyncCommand();
        }
        return methodProxy.invokeSuper(obj, args);
    }
}
