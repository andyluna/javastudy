package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @time: 2021/6/30 六月 15:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class RoleDaoHibernateImpl implements RoleDao {
    private static final Logger log = LoggerFactory.getLogger(RoleDaoHibernateImpl.class);
    @Override
    public List<Role> queryRoleList(String code, String name, Integer createUserId, Integer curPage, Integer pageSize) {
        return null;
    }

    @Override
    public int queryRoleTotal(String code, String name, Integer createUserId) {
        return 0;
    }

    @Override
    public int deleteRole(Integer id) {
        return 0;
    }

    @Override
    public int addRole(Role role) {
        return 0;
    }

    @Override
    public Role queryRoleById(Integer id) {
        return null;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }
}
