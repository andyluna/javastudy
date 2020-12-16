package com.andy.study.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @time: 2020/12/1 十二月 16:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Controller
@Slf4j
public class MyController02 implements InitializingBean {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        log.debug("hello");
        return LocalDateTime.now().toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("初始化成功");
    }
}
