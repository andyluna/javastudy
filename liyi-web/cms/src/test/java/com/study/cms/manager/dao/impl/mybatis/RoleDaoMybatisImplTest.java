package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Role;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/30 18:23  星期三
 */
public class RoleDaoMybatisImplTest {
    RoleDao roleDao=new RoleDaoMybatisImpl();

    @Test
    public void queryRoleList() {
        List<Role> roles = roleDao.queryRoleList("001", "liyi", 1, 1, 20);
        for (Role role:roles){
            System.out.println(role);
        }
    }

    @Test
    public void queryRoleTotal() {
        int i = roleDao.queryRoleTotal(null, "liyi", 1);
        System.out.println("查询出"+i+"条数据");
    }

    @Test
    public void deleteRole() {
        roleDao.deleteRole(48);
        System.out.println("删除成功");
    }

    @Test
    public void addRole() {
        roleDao.addRole(new Role(null,"00888088","liyi00888",new Date(),1,new Date(),1));
        System.out.println("添加了一条数据");
    }

    @Test
    public void queryRoleById() {
        Role role = roleDao.queryRoleById(43);
        System.out.println(role);
    }

    @Test
    public void updateRole() {
        roleDao.updateRole(new Role(49,"00909","liyi00999",new Date(),1,new Date(),2));
        System.out.println("修改成功");
    }
}