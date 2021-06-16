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
public class LogoutServlet extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(LogoutServlet.class);


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        log.debug("开始退出");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_KEY);
        session.invalidate();
        if(user!=null){
            log.debug("用户[{}] 成功退出了系统",user.getUsername());
        }else{
            log.debug("当前session 已经退出了 ");
        }

        writeRes(resp,AjaxRes.success("退出成功"));
    }




    private void writeRes(HttpServletResponse resp,AjaxRes ajaxRes)throws ServletException, IOException{

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(ajaxRes.toString());
        writer.flush();
        writer.close();

    }


}
