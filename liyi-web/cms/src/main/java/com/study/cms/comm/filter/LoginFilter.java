package com.study.cms.comm.filter;

import com.study.cms.comm.utils.Constants;
import com.study.cms.manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 拦截是否登录的过滤器
 * 所有的后台请求路径路径 都是 /admin/*
 * @time: 2021/6/16 六月 08:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class LoginFilter extends HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    private Set<String> ignorePath;//忽略哪些不需要登录的页面路径
    @Override
    public void init() throws ServletException {
        log.debug("loginFilter登录拦截过滤器初始化成功");
        String path = super.getInitParameter("ignorePath");
        String[] ps = path.split(",");
        ignorePath = new HashSet<>(Arrays.asList(ps));
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        uri = uri.substring(request.getContextPath().length());
        log.debug("登录过滤器拦截的 URI = {}",uri);


        if(isIgnorePath(uri)){//如果当前路径是一个忽略的路径则直接放行
            log.debug("当前路径{} 是不需要登录的路径 直接忽略 ",uri);
            super.doFilter(request, response, chain);
            return;
        }

        User user = (User) session.getAttribute(Constants.SESSION_KEY);
        if(user==null){//没有登录的页面 并且 并且是忽略路径
            log.debug("访问这个路径时{} 需要登录 但是却没有登录 ",uri);
            response.sendRedirect(request.getContextPath()+"/pages/manager/managerLogin.jsp");
            //重定向到登录页面
            return;
        }

        log.debug("其余的情况已经登录了 直接放行");
        super.doFilter(request, response, chain);
    }

    private boolean isIgnorePath(String path){

        return ignorePath.stream().anyMatch(s->{
            if(s.equals("/")){
                return path.equals(s);
            }else if(s.endsWith("jsp") || s.endsWith("js") || s.endsWith("css")|| s.endsWith("png") || s.endsWith("jpeg")){
                return path.endsWith(s);
            }else {
                return path.startsWith(s);
            }
        });
    }
    @Override
    public void destroy() {
        log.debug("loginFilter登录拦截过滤器销毁成功");

    }
}
