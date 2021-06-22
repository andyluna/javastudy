package com.study.cms.manager.dao;

import com.study.cms.manager.dao.impl.RoleDaoImpl;
import com.study.cms.manager.entity.Role;
import org.junit.Test;

import java.util.Date;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 19:45  星期二
 */
public class RoleDaoTest {
    RoleDao roleDao=new RoleDaoImpl();

    @Test
    public void addRole() {
        for (int i=1;i<40;i++){
            Role role=new Role(null,"007"+i,"liyi7"+i,new Date(),1,new Date(),1);
            roleDao.addRole(role);
        }

    }


}