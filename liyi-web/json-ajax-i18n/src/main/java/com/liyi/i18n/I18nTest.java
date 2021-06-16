package com.liyi.i18n;

import org.testng.annotations.Test;

import java.util.Locale;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/15 21:55  星期二
 */
public class I18nTest {


    @Test
    public void test1(){
        //获取系统默认的语言  国家信息
        Locale locale=Locale.getDefault();
        System.out.println(locale);

//        for (Locale availableLocale : locale.getAvailableLocales()) {
//            System.out.println(availableLocale);
//        }
        //获取中文 中文的常量Local对象
        System.out.println(Locale.CHINA);
    }
}
