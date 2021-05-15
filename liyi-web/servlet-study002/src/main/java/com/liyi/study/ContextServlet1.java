package com.liyi.study; /**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/15 17:27  星期六
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取servletContext对象
        ServletContext context=getServletContext();

        System.out.println("保存之前key1的值是："+context.getAttribute("key1"));

        context.setAttribute("key1","value1");
        System.out.println("key1的值是："+context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
