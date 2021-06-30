package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.comm.utils.MyBatisUtil;
import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.entity.Dept;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 23:09  星期二
 */
public class DeptMyBatisDaoImpl implements DeptDao {
    private final static Logger log = LoggerFactory.getLogger(DeptMyBatisDaoImpl.class);

    @Override
    public Dept queryByName(String name) {
        SqlSession session = MyBatisUtil.getSession(true);
        Dept dept = session.selectOne("com.study.cms.manager.mapper.DeptMapper.queryByName",name);
        return dept;
    }

    @Override
    public Dept queryByName(Integer id, String name) {

        SqlSession session = MyBatisUtil.getSession(true);
        Dept dept1 = new Dept();
        dept1.setId(id);
        dept1.setName(name);
        Dept dept = session.selectOne("com.study.cms.manager.mapper.DeptMapper.queryByName1",dept1);
        return dept;
    }

    @Override
    public Dept queryDeptById(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        Dept dept = session.selectOne("com.study.cms.manager.mapper.DeptMapper.queryDeptById",id);
        return dept;
    }

    @Override
    public Dept queryDeptByCode(Integer code) {
        SqlSession session = MyBatisUtil.getSession(true);
        Dept dept = session.selectOne("com.study.cms.manager.mapper.DeptMapper.queryDeptByCode",code.toString());
        return dept;
    }

    @Override
    public List DeptList() {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.selectList("com.study.cms.manager.mapper.DeptMapper.DeptList");
    }

    @Override
    public int addDept(Dept dept) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.DeptMapper.addDept",dept);
    }

    @Override
    public int deleteDept(Integer id) {

        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.DeptMapper.deleteDept",id);

    }

    @Override
    public int updateDept(Dept dept) {
        SqlSession session = MyBatisUtil.getSession(true);
        session.update("com.study.cms.manager.mapper.DeptMapper.updateDept",dept);
        return 1;
    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name==null?null:name+"%");
        map.put("code",code==null?null:code+"%");
        map.put("parentCode",parentCode==null?null:parentCode+"%");
        List<Dept> list = session.selectList("com.study.cms.manager.mapper.DeptMapper.queryDeptList", map);
        return list;
    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode, Integer curPage, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name==null?null:name+"%");
        map.put("code",code==null?null:code+"%");
        map.put("parentCode",parentCode==null?null:parentCode+"%");
//        map.put("curPage",curPage);
//        map.put("pageSize",pageSize);
        map.put("firstPage",(curPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Dept> list = session.selectList("com.study.cms.manager.mapper.DeptMapper.queryDeptList1", map);
        return list;
    }

    @Override
    public int queryDeptTotal(String name, String code, String parentCode) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name==null?null:name+"%");
        map.put("code",code==null?null:code+"%");
        map.put("parentCode",parentCode==null?null:parentCode+"%");
        Integer total = session.selectOne("com.study.cms.manager.mapper.DeptMapper.queryDeptTotal", map);
        return total;

    }
}
