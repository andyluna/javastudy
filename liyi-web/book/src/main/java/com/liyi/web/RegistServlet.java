package com.liyi.web;

import com.liyi.pojo.User;
import com.liyi.service.UserService;
import com.liyi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
        //检查用户名是否可用
            if (userService.existsUsername(username)) {

                req.setAttribute("msg","用户名已存在!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
        //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //如果可用
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));

                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }
        else {
            //把回显的信息保存到request域中
            req.setAttribute("msg","验证码错误!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);



            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
