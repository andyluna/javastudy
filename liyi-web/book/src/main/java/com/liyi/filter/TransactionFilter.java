package com.liyi.filter;

import com.liyi.utils.JDBCUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/14 18:37  星期一
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            //提交事务
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            //回滚事务
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            //把异常再抛给Tomcat管理展示友好的错误页面
            throw new RuntimeException(e);

        }
    }

    @Override
    public void destroy() {

    }
}
