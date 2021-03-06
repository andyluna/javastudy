package com.andy.study.springmvc.servlet.initializer;

import com.andy.study.springmvc.servlet.MyServerletInitializer;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;

/**
 * @time: 2020/12/1 十二月 13:39
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyInit01 implements MyServerletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        log.debug("MyInit01 启动了:{}", servletContext);
    }
}
