package com.andy.study.jvm.dynimic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @time: 2020/10/24 十月 16:08
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyHandler implements InvocationHandler {

    public Object obj;

    public MyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前");

        Object o = method.invoke(obj, args);
        System.out.println("方法执行后");
        return o;
    }
}
