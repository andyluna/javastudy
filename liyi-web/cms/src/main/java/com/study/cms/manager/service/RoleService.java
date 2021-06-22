package com.study.cms.manager.service;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.Role;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 16:57  星期二
 */
public interface RoleService {

    PageRes queryRolesPage(String code, String name, Integer createUserId, Integer curPage, Integer pageSize);

    void deleteRoleById(Integer id);

    Role queryRoleById(Integer id);

    void addRole(Role role);

    void updateRole(Role role);
}
