package com.study.cms.comm.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @time: 2021/6/16 六月 10:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BasePathFilter extends HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(BasePathFilter.class);

    @Override
    public void init() throws ServletException {
        log.debug("BasePathFilter初始化成功,这个过滤器的目的是为所有的请求 都统一设置path和basePath路径");
    }

    /**
     * 为所有的请求统一设置path和basePath 这样的话 在jsp页面就不需要单独设置了
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        request.setAttribute("path",path);
        request.setAttribute("basePath", basePath);
        super.doFilter(request, response, chain);
    }
    @Override
    public void destroy() {
        log.debug("BasePathFilter销毁成功");

    }
}
