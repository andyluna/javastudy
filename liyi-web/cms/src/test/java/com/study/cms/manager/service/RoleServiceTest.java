package com.study.cms.manager.service;

import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.dao.impl.RoleDaoImpl;
import com.study.cms.manager.entity.Role;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 20:25  星期二
 */
public class RoleServiceTest {
    RoleDao roleDao=new RoleDaoImpl();

    @Test
    public void queryRoleById() {
        System.out.println(roleDao.queryRoleById(20));
    }


    @Test
    public void updateRoleById(){
        int i = roleDao.updateRole(new Role(47, "a", "liyi999", new Date(), 1, new Date(), 1));
        System.out.println(i);
    }
}