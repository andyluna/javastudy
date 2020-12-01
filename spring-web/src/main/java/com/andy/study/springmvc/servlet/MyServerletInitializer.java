package com.andy.study.springmvc.servlet;

import javax.servlet.ServletContext;

/**
 * @time: 2020/12/1 十二月 13:35
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface MyServerletInitializer {

    void onStartup(ServletContext servletContext);

}
