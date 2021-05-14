package com.andy.study.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/14 23:46  星期五
 */
public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("HelloServlet构造方法执行成功");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet --- init 方法执行成功 config = "+config);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("开始执行Service方法了");
        String remoteHost = req.getRemoteHost();
        String remoteAddr = req.getRemoteAddr();
        int remotePort = req.getRemotePort();
        String name = req.getParameter("name");
        String liyi = req.getParameter("liyi");

        System.out.println("remoteHost = "+remoteHost);
        System.out.println("remoteAddr = "+remoteAddr);
        System.out.println("remotePort = "+remotePort);
        System.out.println("name       = "+name);
        System.out.println("liyi       = "+liyi);

        res.setContentType("text/html;charset=UTF-8");

        String res1 = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>servlet-study001首页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>name = " +name+"</h1>"+
                "<h2 style='color:red;'>liyi = " +liyi+"</h2>"+
                "</body>\n" +
                "</html>";


        PrintWriter writer = res.getWriter();
        writer.write(res1);
        writer.flush();
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "这是我的第一个ServletInfo";
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet --- destroy方法执行了");
    }
}
