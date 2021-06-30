package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.comm.utils.MyBatisUtil;
import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.Role;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @time: 2021/6/30 六月 15:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class RoleDaoMybatisImpl implements RoleDao {
    private static final Logger log = LoggerFactory.getLogger(RoleDaoMybatisImpl.class);
    @Override
    public List<Role> queryRoleList(String code, String name, Integer createUserId, Integer curPage, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",code==null?null:code+"%");
        map.put("name",name==null?null:name+"%");
        map.put("createUserId",createUserId==null?null:createUserId+"%");

        map.put("firstPage",(curPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Role> list = session.selectList("com.study.cms.manager.mapper.RoleMapper.queryRoleList", map);
        return list;
    }

    @Override
    public int queryRoleTotal(String code, String name, Integer createUserId) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",code==null?null:code+"%");
        map.put("name",name==null?null:name+"%");
        map.put("createUserId",createUserId==null?null:createUserId+"%");
        Integer total = session.selectOne("com.study.cms.manager.mapper.RoleMapper.queryRoleTotal", map);
        return total;
    }

    @Override
    public int deleteRole(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.RoleMapper.deleteRole",id);
    }

    @Override
    public int addRole(Role role) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.RoleMapper.addRole",role);
    }

    @Override
    public Role queryRoleById(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        Role role = session.selectOne("com.study.cms.manager.mapper.RoleMapper.queryRoleById",id);
        return role;
    }

    @Override
    public int updateRole(Role role) {
        SqlSession session = MyBatisUtil.getSession(true);
        session.update("com.study.cms.manager.mapper.RoleMapper.updateRole",role);
        return 1;
    }
}
