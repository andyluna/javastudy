package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.AjaxRes;
import com.study.cms.comm.utils.Constants;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;
import com.study.cms.manager.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 22:07  星期三
 */
public class LoginServlet  extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(LoginServlet.class);


    private UserService userService = new UserServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        log.debug("开始登录");
        AjaxRes res = null;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //验证用户名密码
        if(StringUtils.isEmpty(username)){
            //username 错误返回
            res = AjaxRes.error("用户名不能为空");
            writeRes(resp,res);
            return;
        }
        if(StringUtils.isEmpty(password)){
            //password 错误返回
            res = AjaxRes.error("密码不能为空");
            writeRes(resp,res);
            return;
        }

        User user = userService.findUserByUserName(username);


        if(user==null){
            //用户名不存在
            res = AjaxRes.error("用户名不存在");
            writeRes(resp,res);
            return;
        }
        if(!password.equals(user.getPassword())){
            //密码不正确
            res = AjaxRes.error("用户名密码错误");
            writeRes(resp,res);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute(Constants.SESSION_KEY,user);
        log.debug("登录成功 转发到首页");

        res = AjaxRes.success("登录成功");


        writeRes(resp,res);

    }




    private void writeRes(HttpServletResponse resp,AjaxRes ajaxRes)throws ServletException, IOException{

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(ajaxRes.toString());
        writer.flush();
        writer.close();

    }


}
