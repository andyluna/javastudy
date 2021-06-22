package com.study.cms.manager.service.impl;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.dao.impl.RoleDaoImpl;
import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.Role;
import com.study.cms.manager.service.RoleService;

import java.util.List;

import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 17:09  星期二
 */
public class RoleServiceImpl implements RoleService {

    RoleDao roleDao=new RoleDaoImpl();

    @Override
    public PageRes queryRolesPage(String code, String name, Integer createUserId, Integer curPage, Integer pageSize) {
        //1.根据参数查询数据库记录的总数
        int total = roleDao.queryRoleTotal(code,name,createUserId);


        //2.计算总共有多少页
        int totalPage = total%pageSize==0?total/pageSize:+total/pageSize+1;

        curPage = curPage<1?curPage=1:curPage;//如果小于1 强制等于1
        curPage = curPage>totalPage?totalPage:curPage;//如果大于最大页 则等于最大页
        pageSize = pageSize<1?DEFAULT_PAGESIZE:pageSize;

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页
        // 当前页的真实数据
        List list = roleDao.queryRoleList(code,name,createUserId,curPage,pageSize);

        PageRes pageRes = new PageRes();
        pageRes.setTotal(total);
        pageRes.setTotalPage(totalPage);
        pageRes.setCurPage(curPage);
        pageRes.setPageSize(pageSize);
        pageRes.setData(list);

        return pageRes;
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleDao.deleteRole(id);

    }

    @Override
    public Role queryRoleById(Integer id) {
        Role role = roleDao.queryRoleById(id);
        return role;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);

    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);

    }
}
