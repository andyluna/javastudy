package com.andy.study.jvm.cloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @time: 2020/10/22 十月 15:07
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Enumeration<URL> resources = classLoader.getResources("com/andy/study/jvm/cloader/MyTest13.class");

        while(resources.hasMoreElements()){
            URL url = resources.nextElement();

            System.out.println(url);
        }

    }
}
