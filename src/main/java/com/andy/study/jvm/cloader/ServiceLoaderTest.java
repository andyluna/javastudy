package com.andy.study.jvm.cloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @time: 2020/10/23 十月 11:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;
        ClassLoader classLoader = driverClass.getClassLoader();

        System.out.println("driverClass = "+driverClass+" classloader :"+classLoader);
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(driverClass);

        System.out.println("serviceLoader :"+serviceLoader.getClass().getClassLoader());
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Driver next = iterator.next();
            System.out.println(next+"  classloader:"+next.getClass().getClassLoader());
        }
    }

}
