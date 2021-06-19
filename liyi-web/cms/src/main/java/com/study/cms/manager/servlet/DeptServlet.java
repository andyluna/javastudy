package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.AjaxRes;
import com.study.cms.comm.utils.ResponseUtils;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.DeptService;
import com.study.cms.manager.service.impl.DeptServiceImpl;
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
 * @time: 2021/6/19 22:46  星期六
 */
public class DeptServlet extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(DeptServlet.class);


    private DeptService deptService = new DeptServiceImpl();


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
        log.debug("查询部门列表数据");
        //当前页
        Integer curPage  =StringUtils.isEmpty(req.getParameter("curPage")) ?DEFAULT_CURPAGE:Integer.parseInt(req.getParameter("curPage"));// 当前第几页
        //每页展示多少条
        Integer pageSize =StringUtils.isEmpty(req.getParameter("pageSize"))?DEFAULT_PAGESIZE:Integer.parseInt(req.getParameter("pageSize"));;// 当前第每页展示多少条

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页

        String name       = req.getParameter("name");
        String code       = req.getParameter("code");
        String parentCode =  req.getParameter("parentCode");

        //查询全部bum,en
        PageRes pageRes = deptService.queryDeptsPage(name,code,parentCode,curPage,pageSize);
        //保存到request域中

        req.setAttribute("pageRes",pageRes);
        req.setAttribute("name",name);
        req.setAttribute("code",code);
        req.setAttribute("parentCode",parentCode);
        log.debug("查询部门列表数据  完成");
//        //转发到managerDept.jsp
        req.getRequestDispatcher("/pages/manager/managerDept.jsp").forward(req,resp);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id= Integer.parseInt(req.getParameter("id"));
        //删除用户
        deptService.deleteDeptById(id);
        ResponseUtils.writeJson(resp, AjaxRes.success());
    }


    protected void getDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("获取部门信息");
        String id1 = req.getParameter("id");
        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");
        if (StringUtils.isEmpty(id1)) {//新增

        } else {//修改
            //1 获取请求的参数
            int id = Integer.parseInt(id1);
            //2 查询用户信息
            Dept dept = deptService.queryDeptById(id);

            //3 保存到用户到Request域中
            req.setAttribute("dept", dept);
        }
        req.setAttribute("curPage",curPage);
        req.setAttribute("pageSize",pageSize);
        //4 请求转发到managerUpdateDept.jsp页面
        req.getRequestDispatcher("/pages/manager/managerUpdateDept.jsp").forward(req,resp);
    }









}
