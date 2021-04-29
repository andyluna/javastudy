package com.liyi.study.base.day0423;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 23:56  星期五
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();

        FileInputStream fis=new FileInputStream("jdbc.properties");
        pro.load(fis);

      String name=pro.getProperty("name");

      String password=pro.getProperty("password");

        System.out.println("name="+name+","+"password="+password);
    }
}
