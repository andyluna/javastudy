package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.comm.utils.HibernateUtil;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.entity.Menu;
import com.study.cms.manager.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @time: 2021/6/30 六月 15:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MenuDaoHibernateImpl implements MenuDao {
    private static final Logger log = LoggerFactory.getLogger(MenuDaoHibernateImpl.class);
    @Override
    public List<Menu> queryMenuList(String name, String openType, Integer parentId, Integer curPage, Integer pageSize) {
        Session session = null;
        List<Menu> menus = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            String hql="select m from Menu m where 1=1";
            if (StringUtils.isNotEmpty(name)){
                hql+=" and name like :name";
            }
            if (StringUtils.isNotEmpty(openType)){
                hql+=" and openType like :openType";
            }
            if (StringUtils.isNotEmpty(parentId)){
                hql+=" and parentId like :parentId";
            }
            
            Query query = session.createQuery(hql);

            if (StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if (StringUtils.isNotEmpty(openType)){
                query.setParameter("openType",openType+"%");
            }
            if (StringUtils.isNotEmpty(parentId)){
                query.setParameter("parentId",parentId+"%");
            }

            query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize);
            menus=query.getResultList();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return menus;
    }

    @Override
    public int queryMenuTotal(String name, String openType, Integer parentId) {
        Session session = null;
        int n=0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            String hql="select count(m) from Menu m where 1=1 ";
            if (StringUtils.isNotEmpty(name)){
                hql+=" and name like :name";
            }
            if (StringUtils.isNotEmpty(openType)){
                hql+=" and openType like :openType";
            }
            if (StringUtils.isNotEmpty(parentId)){
                hql+=" and parentId like :parentId";
            }

            Query query = session.createQuery(hql);

            if (StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if (StringUtils.isNotEmpty(openType)){
                query.setParameter("openType",openType+"%");
            }
            if (StringUtils.isNotEmpty(parentId)){
                query.setParameter("parentId",parentId+"%");
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
    public int deleteMenu(Integer id) {
        Session session = null;
        Menu menu=null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            menu = session.get(Menu.class, id);
            if (menu!=null){
                session.delete(menu);
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
    public int addMenu(Menu menu) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(menu);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }

    @Override
    public Menu queryMenuById(Integer id) {
        Session session = null;
        Menu menu=null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            menu = session.get(Menu.class, id);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return menu;
    }

    @Override
    public int updateMenu(Menu menu) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            session.update(menu);

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }
}
