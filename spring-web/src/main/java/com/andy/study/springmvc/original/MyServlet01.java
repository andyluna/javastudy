package com.andy.study.springmvc.original;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @time: 2020/12/1 十二月 14:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@WebServlet(urlPatterns = {"/myservlet01"},name = "myservlet01",loadOnStartup = 1)
@Slf4j
public class MyServlet01 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.debug("myservlet01");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


}
