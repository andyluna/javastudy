package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Role;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 23:16  星期三
 */
public class RoleDaoHibernateImplTest {
    RoleDao roleDao=new RoleDaoHibernateImpl();

    @Test
    public void queryRoleList() {
        List<Role> roles = roleDao.queryRoleList(null, null, 1, 1, 10);
        for (Role role:roles){
            System.out.println(role);
        }
    }

    @Test
    public void queryRoleTotal() {
        int i = roleDao.queryRoleTotal(null, null, 1);
        System.out.println("共查到"+i+"条记录");
    }

    @Test
    public void deleteRole() {
        roleDao.deleteRole(51);
        System.out.println("删除成功");
    }

    @Test
    public void addRole() {
        Role role=new Role();
        role.setCode("0989");
        role.setName("liyi0989");
        role.setCreateDate(new Date());
        role.setLastUpdateDate(new Date());
        role.setCreateUserId(1);
        role.setLastUpdateId(1);
        roleDao.addRole(role);
        System.out.println("新增成功");

    }

    @Test
    public void queryRoleById() {
        Role role = roleDao.queryRoleById(51);
        System.out.println(role);
    }

    @Test
    public void updateRole() {
        Role role=new Role();
        role.setId(51);
        role.setCode("0000");
        role.setName("liyi0000");
        role.setCreateDate(new Date());
        role.setLastUpdateDate(new Date());
        role.setCreateUserId(2);
        role.setLastUpdateId(2);
        roleDao.updateRole(role);
        System.out.println("修改成功");
    }
}