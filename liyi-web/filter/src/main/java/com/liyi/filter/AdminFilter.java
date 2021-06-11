package com.liyi.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 20:00  星期五
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("1.Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("AdminFilter的doFilter方法执行了！");

        HttpServletRequest httpServletRequest= (HttpServletRequest) request;

        HttpSession session=httpServletRequest.getSession();

        Object user=session.getAttribute("user");

        if (user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else {
            //让程序继续往下访问用户的目标资源
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter的destroy()销毁方法");
    }
}
