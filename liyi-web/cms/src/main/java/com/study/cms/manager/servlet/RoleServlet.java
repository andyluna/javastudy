package com.study.cms.manager.servlet;

import com.study.cms.comm.utils.AjaxRes;
import com.study.cms.comm.utils.ResponseUtils;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageRes;

import com.study.cms.manager.entity.Role;
import com.study.cms.manager.service.RoleService;
import com.study.cms.manager.service.impl.RoleServiceImpl;
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
 * @time: 2021/6/22 16:55  星期二
 */
public class RoleServlet extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(MenuServlet.class);


    private RoleService roleService=new RoleServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
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
        log.debug("查询角色列表数据");
        //当前页
        Integer curPage  =StringUtils.isEmpty(req.getParameter("curPage")) ?DEFAULT_CURPAGE:Integer.parseInt(req.getParameter("curPage"));// 当前第几页
        //每页展示多少条
        Integer pageSize =StringUtils.isEmpty(req.getParameter("pageSize"))?DEFAULT_PAGESIZE:Integer.parseInt(req.getParameter("pageSize"));;// 当前第每页展示多少条

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页


        String code     = req.getParameter("code");
        String name = req.getParameter("name");
        Integer createUserId = StringUtils.isEmpty(req.getParameter("createUserId"))?null:Integer.parseInt(req.getParameter("createUserId"));


        //查询全部菜单
        PageRes pageRes = roleService.queryRolesPage(code,name,createUserId,curPage,pageSize);
        log.debug(""+pageRes);

        //保存到request域中
        req.setAttribute("pageRes",pageRes);
        req.setAttribute("name",name);
        req.setAttribute("code",code);
        req.setAttribute("createUserId",createUserId);
        log.debug("查询角色列表数据  完成");
//        //转发到managerRole.jsp
        req.getRequestDispatcher("/pages/manager/managerRole.jsp").forward(req,resp);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id= Integer.parseInt(req.getParameter("id"));
        //删除用户
        roleService.deleteRoleById(id);
        ResponseUtils.writeJson(resp, AjaxRes.success());
    }


    protected void getRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("获取角色信息");
        String id1 = req.getParameter("id");
        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");
        if (StringUtils.isEmpty(id1)) {//新增

        } else {//修改
            //1 获取请求的参数
            int id = Integer.parseInt(id1);
            //2 查询用户信息
            Role role = roleService.queryRoleById(id);
            log.debug("getRole="+role);

            //3 保存到Request域中
            req.setAttribute("role", role);
        }
        req.setAttribute("curPage",curPage);
        req.setAttribute("pageSize",pageSize);

        //4 请求转发到managerUpdateRole.jsp页面
        req.getRequestDispatcher("/pages/manager/managerUpdateRole.jsp").forward(req,resp);
    }

    protected void updateRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        log.debug("新增或者修改角色");

        String curPage = req.getParameter("curPage");
        String pageSize = req.getParameter("pageSize");

        String id             = req.getParameter("id");
        String name           = req.getParameter("name");
        String code           = req.getParameter("code");

        String createUserId = null;




        Date createDate = null;
        Date lastUpdateDate  = null;
        Role role = null;

        if( StringUtils.isEmpty(id)){//新增
            //新增时 创建时间和最后修改时间都为当前时间
            createDate=new Date();
            lastUpdateDate=new Date();
            createUserId=req.getParameter("createUserId");

            //新增时创建人id和最后修改人的id为登录人的id
            role=new Role(null,code,name,createDate,Integer.parseInt(createUserId),lastUpdateDate,Integer.parseInt(createUserId));

            log.debug("getMenu="+role);
            roleService.addRole(role);

            log.debug("新增角色{}成功 "+role);
        }else{//修改
            //获取选择修改的创建时间
            String createDate1 = req.getParameter("createDate");

            log.debug("创建时间是:"+createDate1);

            //转换成日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(createDate1);

            //设置最后修改时间为当前时间
            lastUpdateDate=new Date();

            createUserId=req.getParameter("createUserId1");
            //最后修改人的id为当前登录的id
            String lastUpdateId = req.getParameter("lastUpdateId");

            role=new Role(Integer.parseInt(id),code,name,date,Integer.parseInt(createUserId),lastUpdateDate,Integer.parseInt(lastUpdateId));

            log.debug("{}"+role);

            roleService.updateRole(role);
            log.debug("修改角色{}成功 "+role);
        }
        resp.sendRedirect(req.getContextPath()+"/manager/roleServlet?action=list&curPage="+curPage+"&pageSize="+pageSize);
    }
}
