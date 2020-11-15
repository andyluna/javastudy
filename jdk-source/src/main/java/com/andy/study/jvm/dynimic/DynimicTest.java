package com.andy.study.jvm.dynimic;


import java.lang.reflect.Proxy;

/**
 * @time: 2020/10/24 十月 16:09
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class DynimicTest {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = new RealSubject();

        MyHandler handler = new MyHandler(subject);

        Subject o = (Subject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                subject.getClass().getInterfaces(), handler);

        String zz = o.request("zz");

        System.out.println("zzz:"+zz);
        System.out.println("动态代理类:"+o.getClass());
        System.out.println("动态代理类:"+o.getClass().getSuperclass());

    }

}
