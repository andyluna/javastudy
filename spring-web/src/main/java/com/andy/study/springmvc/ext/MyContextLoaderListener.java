package com.andy.study.springmvc.ext;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @time: 2020/12/1 十二月 14:00
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyContextLoaderListener extends ContextLoaderListener {


    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
