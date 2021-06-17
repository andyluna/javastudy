package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;
import com.study.cms.manager.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static com.study.cms.comm.utils.Constants.DEFAULT_CURPAGE;
import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/17 21:18  星期四
 */
public class UserServlet extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(UserServlet.class);

    UserService userService=new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Method method = null;
        try {
            if(StringUtils.isEmpty(action)){
                action = "list";
            }
            log.debug("action = {}",action);
            // 获取action业务鉴别字符串，获取相应的业务 方法反射对象
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            log.debug("method = {}",method);
            method.setAccessible(true);
            // 调用目标业务 方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            log.error("执行方法{}出错了",method,e);
        }
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("查询用户列表数据");
        //当前页
        Integer curPage  =StringUtils.isEmpty(req.getParameter("curPage")) ?DEFAULT_CURPAGE:Integer.parseInt(req.getParameter("curPage"));// 当前第几页
        //每页展示多少条
        Integer pageSize =StringUtils.isEmpty(req.getParameter("pageSize"))?DEFAULT_PAGESIZE:Integer.parseInt(req.getParameter("pageSize"));;// 当前第每页展示多少条


        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页

        String username = req.getParameter("username");
        String name     = req.getParameter("name");
        String sex      =  req.getParameter("sex");

        //查询全部用户
        PageRes pageRes = userService.queryUsersPage(username,name,sex,curPage,pageSize);
        //保存到request域中
        if(StringUtils.isEmpty(sex)){
            sex = "2";
        }
        req.setAttribute("pageRes",pageRes);
        req.setAttribute("username",username);
        req.setAttribute("name",name);
        req.setAttribute("sex",sex);
        log.debug("查询用户列表数据  完成");
        //转发到managerUser.jsp
        req.getRequestDispatcher("/pages/manager/managerUser.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id= Integer.parseInt(req.getParameter("id"));
        //删除用户
        userService.deleteUserById(id);
        resp.sendRedirect("/pages/manager/managerUser.jsp");

    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
