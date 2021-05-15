package com.liyi.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/15 22:59  星期六
 */
public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决响应中文乱码一
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //解决响应中文乱码二  同时设置服务器和客户端的字符集，还设置了响应头
        //注意：在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");


        PrintWriter writer = resp.getWriter();
//        resp.getOutputStream();
        writer.write("response content!!");
        writer.write("我是帅哥");
    }
}
