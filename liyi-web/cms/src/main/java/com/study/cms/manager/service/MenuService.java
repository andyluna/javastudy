package com.study.cms.manager.service;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.Menu;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 15:57  星期一
 */
public interface MenuService {
    PageRes queryMenusPage(String name, String openType, Integer parentId, Integer curPage, Integer pageSize);

    void deleteMenuById(Integer id);

    Menu queryMenuById(Integer id);

    void addMenu(Menu menu);

    void updateMenu(Menu menu);
}
