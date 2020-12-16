package com.andy.study.springmvc.original;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @time: 2020/12/1 十二月 14:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
//@WebFilter(urlPatterns = {"/*"},description = "自定义注解过滤器",
//        initParams = {
//        @WebInitParam(name = "a",value = "a1",description = "a11"),
//        @WebInitParam(name = "b",value = "b1",description = "b11"),
//        },asyncSupported = true)
@Slf4j
public class MyFilter01 extends HttpFilter {

    @Override
    public void init() throws ServletException {
        String a = super.getInitParameter("a");
        String b = super.getInitParameter("b");
        log.debug("MyFilter01 初始化成功:{},{}", a, b);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        super.doFilter(req, res, chain);
    }
}
