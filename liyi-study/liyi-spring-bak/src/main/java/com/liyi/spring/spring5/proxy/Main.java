package com.liyi.spring.spring5.proxy;

import com.liyi.spring.spring5.proxy.impl.MaopiaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 23:28  星期日
 */
public class Main {

    public static void main(String[] args) {
        Maipiao mp = new MaopiaoImpl();

        String s1 = mp.train1();

        System.out.println("火车票 = "+s1);


        String s = mp.fly1();
        System.out.println("飞机票 = "+s );
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        ClassLoader loader = mp.getClass().getClassLoader();
        Class<?>[] interfaces  = mp.getClass().getInterfaces();
        InvocationHandler h = new MapPiaoInvocationHandler(mp);
        Maipiao o = (Maipiao) Proxy.newProxyInstance(loader, interfaces, h);

        s1 = o.train1();

        System.out.println("代理之后火车票 = "+s1);


        s = o.fly1();
        System.out.println("代理之后飞机票 = "+s );

    }
}
