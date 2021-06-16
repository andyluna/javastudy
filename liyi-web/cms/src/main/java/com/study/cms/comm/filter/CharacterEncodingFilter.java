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
 * 字符编码过滤器
 * 拦截所有的请求,设置请求编码为UTF-8
 * @time: 2021/6/16 六月 08:58
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class CharacterEncodingFilter extends HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);

    private String encoding;//web.xml文件里面配置的编码

    @Override
    public void init() throws ServletException {
        this.encoding = super.getInitParameter("encoding");
        log.debug("web.xml配置文件里面配置的编码encoding={}",encoding);
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        log.debug("设置request和response的编码都为:{}",encoding);
        super.doFilter(request, response, chain);
    }

    @Override
    public void destroy() {
        log.debug("字符编码过滤器销毁成功,这个方法只在tomcat容器销毁的时候才执行");
    }
}
