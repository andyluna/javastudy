package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.comm.dao.impl.CommonDaoHibernateImpl;
import com.study.cms.comm.utils.HibernateUtil;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 22:55  星期二
 */
public class DeptHibernateDaoImpl implements DeptDao {
    private final static Logger log = LoggerFactory.getLogger(DeptHibernateDaoImpl.class);
    private CommonDaoEnhance commonDaoEnhance = new CommonDaoHibernateImpl();
    @Override
    public Dept queryByName(String name) {

        Dept dept = new Dept();
        dept.setName(name);
        Dept o = commonDaoEnhance.selectOne(dept);
        return o;
    }

    @Override
    public Dept queryByName(Integer id, String name) {
        Dept dept = new Dept();
        dept.setId(id);
        dept.setName(name);
        Dept o = commonDaoEnhance.selectOne(dept);
        return o;
    }

    @Override
    public Dept queryDeptById(Integer id) {
        //方式1
//        Dept dept = new Dept();
//        dept.setId(id);
//        Dept o = commonDaoEnhance.selectOne(dept);

        //方式2
        Session session = HibernateUtil.getTransactionSession();
        Dept dept1 = session.get(Dept.class, id);
        HibernateUtil.close(session);
        return dept1;
    }

    @Override
    public Dept queryDeptByCode(Integer code) {
        Dept dept = new Dept();
        dept.setCode(code.toString());
        Dept o = commonDaoEnhance.selectOne(dept);
        return o;
    }

    @Override
    public List DeptList() {
        return commonDaoEnhance.selectList(new Dept());
    }

    @Override
    public int addDept(Dept dept) {
        commonDaoEnhance.insert(dept);
        return 1;
    }

    @Override
    public int deleteDept(Integer id) {
        commonDaoEnhance.deleteById(Dept.class,id);
        return 1;
    }

    @Override
    public int updateDept(Dept dept) {
        commonDaoEnhance.update(dept);
        return 1;
    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode) {
        Dept dept = new Dept();
        dept.setName(name);
        dept.setCode(code);
        dept.setParentCode(parentCode);
        List<Dept> objects = commonDaoEnhance.selectList(dept);
        return objects;
    }

    @Override
    public List<Dept> queryDeptList(String name, String code, String parentCode, Integer curPage, Integer pageSize) {

        //方式2
        Session session = HibernateUtil.getTransactionSession();
        StringBuilder hql = new StringBuilder();

        hql.append("select s from Dept s where 1=1 ");
        if(StringUtils.isNotEmpty(name)){
            hql.append(" name like :name1");
        }
        if(StringUtils.isNotEmpty(code)){
            hql.append(" code like :code");
        }
        if(StringUtils.isNotEmpty(parentCode)){
            hql.append(" parentCode like :parentCode");
        }

        Query query = session.createQuery(hql.toString());

        if(StringUtils.isNotEmpty(name)){
            query.setParameter("name1",code+"%");
        }
        if(StringUtils.isNotEmpty(code)){
            query.setParameter("code",code+"%");
        }
        if(StringUtils.isNotEmpty(parentCode)){
            query.setParameter("parentCode",parentCode+"%");
        }
        query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize);
        List list = query.getResultList();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int queryDeptTotal(String name, String code, String parentCode) {
        //方式2
        Session session = HibernateUtil.getTransactionSession();
        StringBuilder hql = new StringBuilder();

        hql.append("select count(s) from Dept s where 1=1 ");
        if(StringUtils.isNotEmpty(name)){
            hql.append(" name like :name1");
        }
        if(StringUtils.isNotEmpty(code)){
            hql.append(" code like :code");
        }
        if(StringUtils.isNotEmpty(parentCode)){
            hql.append(" parentCode like :parentCode");
        }

        Query query = session.createQuery(hql.toString());

        if(StringUtils.isNotEmpty(name)){
            query.setParameter("name1",code+"%");
        }
        if(StringUtils.isNotEmpty(code)){
            query.setParameter("code",code+"%");
        }
        if(StringUtils.isNotEmpty(parentCode)){
            query.setParameter("parentCode",parentCode+"%");
        }
        Number list = (Number) query.getSingleResult();
        HibernateUtil.close(session);
        return list.intValue();
    }

    @Override
    public List<Dept> queryAll() {
        Session session = null;
        List<Dept> depts=null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            String hql ="select d from Dept d";
            depts = session.createQuery(hql).getResultList();
            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return depts;
    }
}
