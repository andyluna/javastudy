package com.study.cms.manager.dao;

import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.Role;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 17:11  星期二
 */
public interface RoleDao {
    List<Role> queryRoleList(String code, String name, Integer createUserId, Integer curPage, Integer pageSize);

    int queryRoleTotal(String code, String name, Integer createUserId);

    int deleteRole(Integer id);

    int addRole(Role role);

    Role queryRoleById(Integer id);

    int updateRole(Role role);
}
