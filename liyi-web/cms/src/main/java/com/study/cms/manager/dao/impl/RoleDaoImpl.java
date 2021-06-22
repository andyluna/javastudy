package com.study.cms.manager.dao.impl;

import com.study.cms.comm.dao.BaseDao;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageTotal;
import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 17:14  星期二
 */
public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> queryRoleList(String code, String name, Integer createUserId, Integer curPage, Integer pageSize) {
        StringBuilder sql=new StringBuilder("select id,code,name,create_date createDate,create_user_id createUserId,last_update_date lastUpdateDate,last_update_id lastUpdateId from c_role where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(code)){
            sql.append(" and code like ? ");
            list.add("%"+code.trim()+"%");
        }
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(createUserId != null){
            sql.append(" and create_user_id = ? ");
            list.add(createUserId);
        }
        sql.append(" limit ? , ? ");

        list.add((curPage-1)*pageSize);
        list.add(pageSize);
        Object[] param = list.toArray(new Object[]{});
        List<Role> roles = BaseDao.queryJavaBeanList(Role.class, sql.toString(), param);
        System.out.println(roles);
        return roles;
    }

    @Override
    public int queryRoleTotal(String code, String name, Integer createUserId) {
        StringBuilder sql=new StringBuilder("select  count(id)  total from c_role where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(code)){
            sql.append(" and code like ? ");
            list.add("%"+code.trim()+"%");
        }
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(createUserId != null){
            sql.append(" and create_user_id = ? ");
            list.add(createUserId);
        }

        Object[] param = list.toArray(new Object[]{});
        PageTotal total = BaseDao.queryJavaBean(PageTotal.class, sql.toString(), param);
        return total.getTotal();
    }

    @Override
    public int deleteRole(Integer id) {
        String sql="delete from c_role where id=?";
        return BaseDao.update(sql,id);
    }

    @Override
    public int addRole(Role role) {
        String sql="insert into c_role(code,name,create_date,create_user_id,last_update_date,last_update_id)values(?,?,?,?,?,?)";
        return BaseDao.update(sql,role.getCode(),role.getName(),role.getCreateDate(),role.getCreateUserId(),role.getLastUpdateDate(),role.getLastUpdateId());

    }

    @Override
    public Role queryRoleById(Integer id) {
        String sql="select id,code,name,create_date createDate,create_user_id createUserId,last_update_date lastUpdateDate,last_update_id lastUpdateId from c_role where id=?";
        return BaseDao.queryJavaBean(Role.class,sql,id);
    }

    @Override
    public int updateRole(Role role) {
        String sql="update c_role set code=?, name=? , create_date=? , create_user_id=? , last_update_date=? , last_update_id=? where id=?";
        return BaseDao.update(sql,role.getCode(),role.getName(),role.getCreateDate(),role.getCreateUserId(),role.getLastUpdateDate(),role.getLastUpdateId(),role.getId());

    }
}
