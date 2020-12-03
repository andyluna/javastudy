package com.andy.study.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @time: 2020/12/2 十二月 14:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Controller
@RequestMapping("/mycontroller")
@Slf4j
public class MyController implements InitializingBean {

    @GetMapping("/hello")
    public String test01(){
        log.debug("hello");
        return "hello";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("MyController");
    }
}
