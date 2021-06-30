package com.study.cms.manager.dao.impl;

import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.dao.impl.jdbc.MenuDaoImpl;
import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 16:42  星期一
 */
public class MenuDaoImplTest {

    MenuDao menuDao=new MenuDaoImpl();

    @Test
    public void deleteMenu() {
    }

    @Test
    public void addMenu() {
//        menuDao.addMenu(new Menu(null, "部门管理", "http://localhost:8080/cms/deptServlet", "登录后打开", "001", new Date(), new Date()));
    }

    @Test
    public void addMenuList() {
//        for (int i=0;i<50;i++){
//            menuDao.addMenu(new Menu(null, "部门管理"+i, "http://localhost:8080/cms/deptServlet", "登录后打开", i+"",new Date(), new Date()));
//        }

    }


    @Test
    public void queryMenuTotal(){
//        int i = menuDao.queryMenuTotal(null, null, "1");
//        System.out.println(i);
    }


    @Test
    public void MenuList(){
//        List<Menu> menuList = menuDao.queryMenuList(null, null, "1", 1, 20);
//        System.out.println(menuList);
    }


}