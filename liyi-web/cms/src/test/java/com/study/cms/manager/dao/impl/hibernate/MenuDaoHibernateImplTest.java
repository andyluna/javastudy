package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.entity.Menu;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 22:40  星期三
 */
public class MenuDaoHibernateImplTest {
    MenuDao menuDao=new MenuDaoHibernateImpl();

    @Test
    public void queryMenuList() {
        List<Menu> menus = menuDao.queryMenuList("部门", "登录后", null, 1, 30);
        menus.forEach(System.out::println);
    }

    @Test
    public void queryMenuTotal() {
        int i = menuDao.queryMenuTotal("部门", "登录后", null);
        System.out.println("查询到"+i+"条记录");
    }

    @Test
    public void deleteMenu() {
        menuDao.deleteMenu(60);
        System.out.println("删除成功");
    }

    @Test
    public void addMenu() {
        Menu menu=new Menu();
        menu.setName("部门管理888");
        menu.setOpenType("登录后打开");
        menu.setUrl("host8080");
        menu.setParentId("44");
        menu.setCreateDate(new Date());
        menu.setLastUpdateDate(new Date());
        menuDao.addMenu(menu);
        System.out.println("新增成功");
    }

    @Test
    public void queryMenuById() {
        Menu menu = menuDao.queryMenuById(60);
        System.out.println(menu);
    }

    @Test
    public void updateMenu() {
        Menu menu=new Menu();
        menu.setId(60);
        menu.setName("部门管理99");
        menu.setOpenType("当前页");
        menu.setUrl("host8080");
        menu.setParentId("44");
        menu.setCreateDate(new Date());
        menu.setLastUpdateDate(new Date());
        menuDao.updateMenu(menu);
        System.out.println("修改成功");

    }
}