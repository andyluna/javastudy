package com.liyi.study; /**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/15 0:16  星期六
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet的doGet方法");

        ServletConfig servletConfig=getServletConfig();
        System.out.println(servletConfig+"doGet的方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet的doPost方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init();
        //获取servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
        System.out.println("初始化参数username的值是: "+servletConfig.getInitParameter("username"));
        System.out.println("servletContext对象是："+servletConfig.getServletContext());

    }
}
