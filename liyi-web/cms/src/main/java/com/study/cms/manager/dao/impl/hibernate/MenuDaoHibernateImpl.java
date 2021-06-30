package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.entity.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @time: 2021/6/30 六月 15:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MenuDaoHibernateImpl implements MenuDao {
    private static final Logger log = LoggerFactory.getLogger(MenuDaoHibernateImpl.class);
    @Override
    public List<Menu> queryMenuList(String name, String openType, Integer parentId, Integer curPage, Integer pageSize) {
        return null;
    }

    @Override
    public int queryMenuTotal(String name, String openType, Integer parentId) {
        return 0;
    }

    @Override
    public int deleteMenu(Integer id) {
        return 0;
    }

    @Override
    public int addMenu(Menu menu) {
        return 0;
    }

    @Override
    public Menu queryMenuById(Integer id) {
        return null;
    }

    @Override
    public int updateMenu(Menu menu) {
        return 0;
    }
}
