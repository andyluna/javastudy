package com.study.cms.manager.dao.impl;

import com.study.cms.comm.dao.BaseDao;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageTotal;
import com.study.cms.manager.MenuDao;

import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 16:02  星期一
 */
public class MenuDaoImpl implements MenuDao {
    @Override
    public List<Menu> queryMenuList(String name, String openType, Integer parentId, Integer curPage, Integer pageSize) {
        StringBuilder sql=new StringBuilder("select id,name,url,open_type openType,parent_id parentId,create_date createDate,last_update_date lastUpdateDate from c_menu where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(openType)){
            sql.append(" and open_type like ? ");
            list.add("%"+openType.trim()+"%");
        }
        if(parentId != null){
            sql.append(" and parent_id = ? ");
            list.add(parentId);
        }
        sql.append(" limit ? , ? ");

        list.add((curPage-1)*pageSize);
        list.add(pageSize);
        Object[] param = list.toArray(new Object[]{});
        List<Menu> menus = BaseDao.queryJavaBeanList(Menu.class, sql.toString(), param);
        System.out.println(menus);
        return menus;
    }

    @Override
    public int queryMenuTotal(String name, String openType, Integer parentId) {
        StringBuilder sql=new StringBuilder("select  count(id)  total from c_menu where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(openType)){
            sql.append(" and open_type like ? ");
            list.add("%"+openType.trim()+"%");
        }
        if(parentId != null){
            sql.append(" and parent_id = ? ");
            list.add(parentId);
        }

        Object[] param = list.toArray(new Object[]{});
        PageTotal total = BaseDao.queryJavaBean(PageTotal.class, sql.toString(), param);
        return total.getTotal();
    }

    @Override
    public int deleteMenu(Integer id) {
        String sql="delete from c_menu where id=?";
        return BaseDao.update(sql,id);
    }

    @Override
    public int addMenu(Menu menu) {
        String sql="insert into c_menu(name,url,open_type,parent_id,create_date,last_update_date)values(?,?,?,?,?,?)";
        return BaseDao.update(sql,menu.getName(),menu.getUrl(),menu.getOpenType(),menu.getParentId(),menu.getCreateDate(),menu.getLastUpdateDate());

    }

    @Override
    public Menu queryMenuById(Integer id) {
        String sql="select id,name,url,open_type openType,parent_id parentId,create_date createDate,last_update_date lastUpdateDate from c_menu where id=?";
        return BaseDao.queryJavaBean(Menu.class,sql,id);
    }

    @Override
    public int updateMenu(Menu menu) {
        String sql="update c_dept set name=? , url=? ,open_type=? ,parent_id=? ,create_date=? ,last_update_date=? where id=?";
        return BaseDao.update(sql,menu.getName(),menu.getUrl(),menu.getOpenType(),menu.getParentId(),menu.getCreateDate(),menu.getLastUpdateDate(),menu.getId());

    }


}
