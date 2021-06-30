package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.comm.utils.HibernateUtil;
import com.study.cms.comm.utils.StringUtils;


import com.study.cms.manager.dao.RoleDao;
import com.study.cms.manager.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
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
        Session session = null;
        List<Role> roles=null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            String hql="select r from Role r where 1=1 ";
            if (StringUtils.isNotEmpty(code)){
                hql+=" and code like :code";
            }
            if (StringUtils.isNotEmpty(name)){
                hql+=" and name like :name";
            }
            if (createUserId!=null){
                hql+=" and createUserId =:createUserId";
            }

            Query query = session.createQuery(hql);

            if (StringUtils.isNotEmpty(code)){
                query.setParameter("code",code+"%");
            }
            if (StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if (createUserId!=null){
                query.setParameter("createUserId",createUserId);
            }

            query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize);

            roles=query.getResultList();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return roles;
    }



    @Override
    public int queryRoleTotal(String code, String name, Integer createUserId) {
        Session session = null;
        int n=0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            String hql="select count(r) from Role r where 1=1 ";
            if (StringUtils.isNotEmpty(code)){
                hql+=" and code like :code ";
            }
            if (StringUtils.isNotEmpty(name)){
                hql+=" and name like :name ";
            }
            if (createUserId!=null){
                hql+=" and createUserId =:createUserId ";
            }

            Query query = session.createQuery(hql);

            if (StringUtils.isNotEmpty(code)){
               query.setParameter("code",code+"%");
            }
            if (StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if (createUserId!=null){
                query.setParameter("createUserId",createUserId);
            }

            Number number= (Number) query.getSingleResult();
            n=number.intValue();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return n;
    }

    @Override
    public int deleteRole(Integer id) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Role role=session.get(Role.class,id);
            if (role!=null){
                session.delete(role);
            }

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }

    @Override
    public int addRole(Role role) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(role);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }

    @Override
    public Role queryRoleById(Integer id) {
        Session session = null;
        Role role=null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            role=session.get(Role.class,id);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return role;
    }

    @Override
    public int updateRole(Role role) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(role);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;

    }
}
