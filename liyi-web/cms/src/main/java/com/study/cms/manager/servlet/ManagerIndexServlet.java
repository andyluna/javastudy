package com.study.cms.manager.servlet;

import com.study.cms.comm.listener.PlatformInitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @time: 2021/6/16 六月 10:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ManagerIndexServlet extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(ManagerIndexServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        log.debug("进入了后台首页");

        //直接转发到 managerIndex.jsp

        req.getRequestDispatcher("/pages/manager/managerIndex.jsp").forward(req,resp);

    }




}
