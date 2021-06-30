package com.study.cms.manager.dao.impl.jdbc;

import com.study.cms.comm.dao.BaseDao;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.comm.vo.PageTotal;
import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.entity.Dept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 22:08  星期六
 */
public class DeptDaoImpl implements DeptDao {
    private final static Logger log = LoggerFactory.getLogger(DeptDaoImpl.class);
    @Override
    public Dept queryByName(String name) {
        String sql="select id,name,code,parent_code,create_date,last_update_date from c_dept where name=?";
        Dept dept= BaseDao.queryJavaBean(Dept.class,sql,name);
        return dept;
    }

    @Override
    public Dept queryByName(Integer id, String name) {
        String sql="select id,name,code,parent_code,create_date,last_update_date from c_dept where id=? and name=?";
        Dept dept= BaseDao.queryJavaBean(Dept.class,sql,id,name);
        return dept;
    }

    @Override
    public Dept queryDeptById(Integer id) {
        String sql="select id,name,code,parent_code parentCode,create_date createDate,last_update_date lastUpdateDate from c_dept where id=?";
        Dept dept= BaseDao.queryJavaBean(Dept.class,sql,id);
        return dept;
    }

    @Override
    public Dept queryDeptByCode(Integer code) {
        String sql="select id,name,code,parent_code,create_date,last_update_date from c_dept where code=?";
        Dept dept= BaseDao.queryJavaBean(Dept.class,sql,code);
        return dept;
    }

    @Override
    public List DeptList() {
        String sql="select id,name,code,parent_code,create_date,last_update_date from c_dept";
        return BaseDao.queryJavaBeanList(Dept.class,sql);
    }

    @Override
    public int addDept(Dept dept) {
        String sql="insert into c_dept(name,code,parent_code,create_date,last_update_date)values(?,?,?,?,?)";
        return BaseDao.update(sql,dept.getName(),dept.getCode(),dept.getParentCode(),dept.getCreateDate(),dept.getLastUpdateDate());
    }

    @Override
    public int deleteDept(Integer id) {
        String sql="delete from c_dept where id=?";
        return BaseDao.update(sql,id);
    }

    @Override
    public int updateDept(Dept dept) {
        String sql="update c_dept set name=? , code=? ,parent_code=? ,create_date=? ,last_update_date=? where id=?";
        return BaseDao.update(sql,dept.getName(),dept.getCode(),dept.getParentCode(),dept.getCreateDate(),dept.getLastUpdateDate(),dept.getId());

    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode) {
        StringBuilder sql=new StringBuilder("select id,name,code,parent_code parentCode,create_date createDate,last_update_date lastUpdateDate from c_dept where 1=1");
        List<String> list=new ArrayList();
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(code)){
            sql.append(" and code like ? ");
            list.add("%"+code.trim()+"%");
        }
        if(!StringUtils.isEmpty(parentCode)){
            sql.append(" and parentCode = ? ");
            list.add(parentCode);
        }
        String[] param = list.toArray(new String[]{});
        List<Dept> depts = BaseDao.queryJavaBeanList(Dept.class, sql.toString(), param);
        return depts;
    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode, Integer curPage, Integer pageSize) {
        StringBuilder sql=new StringBuilder("select id,name,code,parent_code parentCode,create_date createDate,last_update_date  lastUpdateDate from c_dept where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(code)){
            sql.append(" and code like ? ");
            list.add("%"+code.trim()+"%");
        }
        if(!StringUtils.isEmpty(parentCode)){
            sql.append(" and parent_code = ? ");
            list.add(parentCode);
        }
        sql.append(" limit ? , ? ");
        list.add((curPage-1)*pageSize);
        list.add(pageSize);
        Object[] param = list.toArray(new Object[]{});
        List<Dept> depts = BaseDao.queryJavaBeanList(Dept.class, sql.toString(), param);
        return depts;
    }

    @Override
    public int queryDeptTotal(String name, String code, String parentCode) {
        StringBuilder sql=new StringBuilder("select  count(id)  total from c_dept where 1=1");
        List<Object> list=new ArrayList();
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(code)){
            sql.append(" and code like ? ");
            list.add("%"+code.trim()+"%");
        }
        if(!StringUtils.isEmpty(parentCode)){
            sql.append(" and parent_code = ? ");
            list.add(parentCode);
        }

        Object[] param = list.toArray(new Object[]{});
        PageTotal  total = BaseDao.queryJavaBean(PageTotal.class, sql.toString(), param);
        return total.getTotal();



    }

    @Override
    public List<Dept> queryAll() {
        StringBuilder sql=new StringBuilder("select id,name,code,parent_code parentCode,create_date createDate,last_update_date lastUpdateDate from c_dept where 1=1");
        List<Dept> depts = BaseDao.queryJavaBeanList(Dept.class, sql.toString(),null);
        return depts;
    }
}
