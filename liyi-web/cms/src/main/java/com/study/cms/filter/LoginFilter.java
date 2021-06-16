package com.study.cms.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截是否登录的过滤器
 * 所有的后台请求路径路径 都是 /admin/*
 * @time: 2021/6/16 六月 08:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LoginFilter extends HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);


    @Override
    public void init() throws ServletException {
        log.debug("loginFilter登录拦截过滤器初始化成功");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        super.doFilter(request, response, chain);
    }
    @Override
    public void destroy() {
        log.debug("loginFilter登录拦截过滤器销毁成功");

    }
}
