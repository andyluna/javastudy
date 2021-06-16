package com.liyi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 20:33  星期五
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if ("admin".equals(username)&&"123".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登录成功！");

        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
