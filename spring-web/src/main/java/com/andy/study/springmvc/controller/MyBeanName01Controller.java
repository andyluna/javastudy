package com.andy.study.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @time: 2020/12/2 十二月 10:11
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyBeanName01Controller implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello");
        mv.addObject("now", LocalDateTime.now());
        mv.setViewName("myBeanName01");
        return mv;
    }
}
