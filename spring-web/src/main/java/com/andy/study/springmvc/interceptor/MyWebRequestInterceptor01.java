package com.andy.study.springmvc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @time: 2020/12/4 十二月 11:35
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyWebRequestInterceptor01 implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {
        log.debug("MyWebRequestInterceptor01 --拦截之前");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        log.debug("MyWebRequestInterceptor01 --拦截之后");

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        log.debug("MyWebRequestInterceptor01 --拦截完成");

    }
}
