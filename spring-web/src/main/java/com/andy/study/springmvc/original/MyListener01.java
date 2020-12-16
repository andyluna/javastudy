package com.andy.study.springmvc.original;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @time: 2020/12/1 十二月 14:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@WebListener
public class MyListener01 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("MyListener01 监听器初始化成功{}", sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.debug("MyListener01 监听器销毁");

    }
}
