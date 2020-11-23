package com.andy.study.spring.xml.di;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @time: 2020/11/20 十一月 23:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CglibTest {

    public static void main(String[] args) {
        Enhancer en = new Enhancer();
        en.setSuperclass(CommandManager.class);
        en.setCallback(new LookupOverrideMethodInterceptor());

        CommandManager cm = (CommandManager) en.create();
        for (int i = 0; i < 5; i++) {
            cm.process("nihao");
        }

    }

}
