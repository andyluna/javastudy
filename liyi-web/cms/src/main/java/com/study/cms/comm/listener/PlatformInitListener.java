package com.study.cms.comm.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 平台启动监听器
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/15 23:32  星期二
 */
public class PlatformInitListener implements ServletContextListener {
    private final static Logger log = LoggerFactory.getLogger(PlatformInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent se) {
        ServletContext context = se.getServletContext();

        String projectName = context.getInitParameter("projectName");
        log.debug("servlet容器[{}]初始化成功,projectName={}", context,projectName);
        log.info("servlet容器[{}]初始化成功,projectName={}", context,projectName);
        log.warn("servlet容器[{}]初始化成功,projectName={}", context,projectName);
        log.error("servlet容器[{}]初始化成功,projectName={}", context,projectName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent se) {
        ServletContext context = se.getServletContext();
        log.debug("servlet容器[{}]销毁成功",context);
    }
}
