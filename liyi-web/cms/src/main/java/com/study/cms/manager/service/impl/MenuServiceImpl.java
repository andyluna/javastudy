package com.study.cms.manager.service.impl;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.dao.impl.hibernate.MenuDaoHibernateImpl;
import com.study.cms.manager.dao.impl.jdbc.MenuDaoImpl;

import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.service.MenuService;

import java.util.List;

import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 15:59  星期一
 */
public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao=new MenuDaoHibernateImpl();

    @Override
    public PageRes queryMenusPage(String name, String openType, Integer parentId, Integer curPage, Integer pageSize) {
        //1.根据参数查询数据库记录的总数
        int total = menuDao.queryMenuTotal(name,openType,parentId);


        //2.计算总共有多少页
        int totalPage = total%pageSize==0?total/pageSize:+total/pageSize+1;

        curPage = curPage<1?curPage=1:curPage;//如果小于1 强制等于1
        curPage = curPage>totalPage?totalPage:curPage;//如果大于最大页 则等于最大页
        pageSize = pageSize<1?DEFAULT_PAGESIZE:pageSize;

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页
        // 当前页的真实数据
        List list = menuDao.queryMenuList(name, openType, parentId,curPage,pageSize);

        PageRes pageRes = new PageRes();
        pageRes.setTotal(total);
        pageRes.setTotalPage(totalPage);
        pageRes.setCurPage(curPage);
        pageRes.setPageSize(pageSize);
        pageRes.setData(list);

        return pageRes;
    }

    @Override
    public void deleteMenuById(Integer id) {
        menuDao.deleteMenu(id);
    }

    @Override
    public Menu queryMenuById(Integer id) {
        Menu menu=menuDao.queryMenuById(id);
        return menu;
    }

    @Override
    public void addMenu(Menu menu) {
        menuDao.addMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }


}
