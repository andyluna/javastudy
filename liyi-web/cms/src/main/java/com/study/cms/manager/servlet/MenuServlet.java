package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.AjaxRes;
import com.study.cms.comm.utils.ResponseUtils;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.Menu;

import com.study.cms.manager.service.MenuService;

import com.study.cms.manager.service.impl.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.study.cms.comm.utils.Constants.DEFAULT_CURPAGE;
import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 22:46  星期六
 */
public class MenuServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(MenuServlet.class);


    private MenuService menuService=new MenuServiceImpl();


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
        log.debug("查询菜单列表数据");
        //当前页
        Integer curPage  =StringUtils.isEmpty(req.getParameter("curPage")) ?DEFAULT_CURPAGE:Integer.parseInt(req.getParameter("curPage"));// 当前第几页
        //每页展示多少条
        Integer pageSize =StringUtils.isEmpty(req.getParameter("pageSize"))?DEFAULT_PAGESIZE:Integer.parseInt(req.getParameter("pageSize"));;// 当前第每页展示多少条

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页

        String name     = req.getParameter("name");
        String openType = req.getParameter("openType");
        Integer parentId = req.getParameter("parentId")==null?null:Integer.parseInt(req.getParameter("parentId"));


        //查询全部菜单
        PageRes pageRes = menuService.queryMenusPage(name,openType,parentId,curPage,pageSize);
        log.debug(""+pageRes);

        //保存到request域中
        req.setAttribute("pageRes",pageRes);
        req.setAttribute("name",name);
        req.setAttribute("openType",openType);
        req.setAttribute("parentId",parentId);
        log.debug("查询菜单列表数据  完成");
//        //转发到managerDept.jsp
        req.getRequestDispatcher("/pages/manager/managerMenu.jsp").forward(req,resp);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id= Integer.parseInt(req.getParameter("id"));
        //删除用户
        menuService.deleteMenuById(id);
        ResponseUtils.writeJson(resp, AjaxRes.success());
    }


    protected void getMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("获取部菜单信息");
        String id1 = req.getParameter("id");
        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");
        if (StringUtils.isEmpty(id1)) {//新增

        } else {//修改
            //1 获取请求的参数
            int id = Integer.parseInt(id1);
            //2 查询用户信息
            Menu menu = menuService.queryMenuById(id);
            log.debug("getMenu="+menu);

            //3 保存到Request域中
            req.setAttribute("menu", menu);
        }
        req.setAttribute("curPage",curPage);
        req.setAttribute("pageSize",pageSize);

        //4 请求转发到managerUpdateDept.jsp页面
        req.getRequestDispatcher("/pages/manager/managerUpdateMenu.jsp").forward(req,resp);
    }

    protected void updateMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        log.debug("新增或者修改菜单");

        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        String openType = req.getParameter("openType");
        String parentId = req.getParameter("parentId");

        Date createDate = null;
        Date lastUpdateDate  = null;
        Menu menu = null;

        if( StringUtils.isEmpty(id)){//新增
            //新增时 创建时间和最后修改时间都为当前时间
            createDate=new Date();
            lastUpdateDate=new Date();

            menu = new Menu(null,name,url,openType,parentId,createDate,lastUpdateDate);
            log.debug("getMenu="+menu);

            menuService.addMenu(menu);
            log.debug("新增菜单{}成功 "+menu);
        }else{//修改
            //获取选择修改的部门的创建时间
            String createDate1 = req.getParameter("createDate");

            log.debug("创建时间是:"+createDate1);

            //转换成日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(createDate1);

            //设置最后修改时间为当前时间
            lastUpdateDate=new Date();

            menu=new Menu(Integer.parseInt(id),name,url,openType,parentId,date,lastUpdateDate);

            log.debug("{}"+menu);

            menuService.updateMenu(menu);
            log.debug("修改菜单{}成功 "+menu);
        }
        resp.sendRedirect(req.getContextPath()+"/manager/menuServlet?action=list&curPage="+curPage+"&pageSize="+pageSize);
    }











}
