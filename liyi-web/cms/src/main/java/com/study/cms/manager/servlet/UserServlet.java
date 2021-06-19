package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.AjaxRes;
import com.study.cms.comm.utils.ResponseUtils;
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
import java.io.PrintWriter;
import java.lang.reflect.Method;

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
        ResponseUtils.writeJson(resp,AjaxRes.success());
    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("新增或者修改用户");

        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");

        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone    =  req.getParameter("phone");
        String name     = req.getParameter("name");
        String address  = req.getParameter("address");
        int sex         = Integer.parseInt(req.getParameter("sex"));
        int dept_id     = Integer.parseInt(req.getParameter("dept_id"));

        User user = null;
        if( StringUtils.isEmpty(id)){//新增
            user = new User(null,username,password,phone,name,address,sex,dept_id);
            userService.addUser(user);
            log.debug("新增用户{}成功 "+user);
        }else{//修改
            user=new User(Integer.parseInt(id),username,password,phone,name,address,sex,dept_id);
            userService.updateUser(user);
            log.debug("修改用户{}成功 "+user);
        }
        resp.sendRedirect(req.getContextPath()+"/manager/userServlet?action=list&curPage="+curPage+"&pageSize="+pageSize);
    }

    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("获取用户信息");
        String id1 = req.getParameter("id");
        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");
        if(StringUtils.isEmpty(id1)){//新增

        }else{//修改
            //1 获取请求的参数
            int id = Integer.parseInt(id1);
            //2 查询用户信息
            User user=userService.queryUserById(id);
            int sex=user.getSex();
            int dept_id=user.getDept_id();

            //3 保存到用户到Request域中
            req.setAttribute("user", user) ;
        }

        req.setAttribute("curPage",curPage);
        req.setAttribute("pageSize",pageSize);
        //4 请求转发到/pages/manager/managerUpdateUser.jsp页面
        req.getRequestDispatcher("/pages/manager/managerUpdateUser.jsp").forward(req,resp);
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String myId=req.getParameter("id");
        String username=req.getParameter("username");
        Integer id = StringUtils.isEmpty(myId)?null:Integer.parseInt(myId.trim());
        //查询用户名是否可用
        boolean existsUserName = userService.existUserByUserName(id,username);

        log.debug("根据 id:{} 和 用户名:{} 判断用户是否存在 {}",id,username,existsUserName);
        AjaxRes res = null;
        if(existsUserName){//错误
            res = AjaxRes.error("用户名"+username+"已经存在");
        }else{//成功
            res = AjaxRes.success("用户名"+username+"不存在");
        }
        ResponseUtils.writeJson(resp,res);
    }




}
