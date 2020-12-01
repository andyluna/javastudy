package com.andy.study.springmvc.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @time: 2020/12/1 十二月 13:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyDispatcherServlet extends DispatcherServlet {

    public MyDispatcherServlet(){
        super();
        log.debug("MyDispatcherServlet启动了");
    }
}
