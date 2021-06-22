package com.study.cms.manager.dao;



import com.study.cms.manager.entity.Menu;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 16:01  星期一
 */
public interface MenuDao {
    List<Menu> queryMenuList(String name, String openType, Integer parentId, Integer curPage, Integer pageSize);

    int queryMenuTotal(String name, String openType, Integer parentId);

    int deleteMenu(Integer id);

    int addMenu(Menu menu);

    Menu queryMenuById(Integer id);

    int updateMenu(Menu menu);
}
