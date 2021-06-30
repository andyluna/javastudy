package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.entity.Menu;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 16:45  星期三
 */
public class MenuDaoMybatisImplTest {

    MenuDao menuDao=new MenuDaoMybatisImpl();
    @Test
    public void queryMenuList() {
        List<Menu> menus = menuDao.queryMenuList("部门管理", "登录后", null, 1, 20);
        for (Menu menu:menus){
            System.out.println(menu);
        }
    }

    @Test
    public void queryMenuTotal() {
        int i = menuDao.queryMenuTotal("部门管理", "登录", null);
        System.out.println("查到总共"+i+"条记录");
    }

    @Test
    public void deleteMenu() {
       menuDao.deleteMenu(58);
        System.out.println("删除了一行数据");

    }


    @Test
    public void addMenu() {
        menuDao.addMenu(new Menu(null,"部门管理999", "www.bumen.com", "登录后打开",
                "45",new Date(),new Date()));
        System.out.println("插入了一行数据");
    }

    @Test
    public void queryMenuById() {
        Menu menu = menuDao.queryMenuById(40);
        System.out.println(menu);
    }

    @Test
    public void updateMenu() {
        menuDao.updateMenu(new Menu(46,"新46部门管理","www.xinurl.com","登录后打开","44",new Date(),new Date()));
        System.out.println("修改了一条数据");
    }
}