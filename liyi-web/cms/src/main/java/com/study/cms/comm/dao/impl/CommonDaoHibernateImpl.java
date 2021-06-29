package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.comm.utils.HibernateUtil;
import com.study.cms.comm.vo.PageRes;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 0:01  星期二
 */
public class CommonDaoHibernateImpl extends CommonDaoJdbcImpl implements CommonDaoEnhance {

    @Override
    public int update(Object o) {
        Session session = HibernateUtil.getTransactionSession();
        session.update(o);
        HibernateUtil.close(session);
        return 1;
    }

    @Override
    public int insert(Object o) {
        Session session = HibernateUtil.getTransactionSession();
        session.save(o);
        HibernateUtil.close(session);
        return 1;
    }

    @Override
    public <T> int deleteById(Class<T> clz, Object id) {
        Session session = HibernateUtil.getTransactionSession();
        T t = session.get(clz, (Serializable) id);
        if(t!=null){
            session.delete(t);
        }
        HibernateUtil.close(session);
        return 1;
    }

    @Override
    public int delete(Object o) {
        Session session = HibernateUtil.getTransactionSession();
        if(o!=null){
            session.delete(o);
        }
        HibernateUtil.close(session);
        return 1;
    }
    //hql
    @Override
    public <T> List<T> selectList(Object o) {
        StringBuilder hql = new StringBuilder("select s from "+o.getClass().getName()+" s where 1=1   ") ;
        Class<?> clz = o.getClass();
        Field[] fields = clz.getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        for(Field f :fields){
            f.setAccessible(true);
            Object o1 = null;
            try {
                o1 = f.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(o1==null) {
                continue;
            }
            if(CharSequence.class.isAssignableFrom(f.getType()) ){
                hql.append(" and ").append( f.getName()).append(" like :"+f.getName());
                map.put(f.getName(), o1+"%");
            }else{
                hql.append(" and ").append( f.getName()).append(" = :"+f.getName());
                map.put(f.getName(), o1);
            }
        }

        Session session = HibernateUtil.getTransactionSession();
        Query query = session.createQuery(hql.toString());
        map.forEach((k,v)->{
            query.setParameter(k,v);
        });
        List<T> list = query.getResultList();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public <T> T selectOne(Object o) {
        StringBuilder hql = new StringBuilder("select s from "+o.getClass().getName()+" s where 1=1    ") ;
        Class<?> clz = o.getClass();
        Field[] fields = clz.getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        for(Field f :fields){
            f.setAccessible(true);
            Object o1 = null;
            try {
                o1 = f.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(o1==null) {
                continue;
            }
            if(CharSequence.class.isAssignableFrom(f.getType()) ){
                hql.append(" and ").append( f.getName()).append(" like :"+f.getName());
                map.put(f.getName(), o1+"%");
            }else{
                hql.append(" and ").append( f.getName()).append(" = :"+f.getName());
                map.put(f.getName(), o1);
            }
        }

        Session session = HibernateUtil.getTransactionSession();
        Query query = session.createQuery(hql.toString());
        map.forEach((k,v)->{
            query.setParameter(k,v);
        });
        T  res = (T) query.getSingleResult();
        HibernateUtil.close(session);
        return res;
    }

    @Override
    public <T> PageRes selectPage(Object o, Integer curPage, Integer pageSize) {
        //1.查询总数 根据参数 查询总数
        StringBuilder hql  = new StringBuilder("select count(s) from "+o.getClass().getName()+" s where 1=1   ") ;
        StringBuilder hql1 = new StringBuilder("select s        from "+o.getClass().getName()+" s where 1=1   ") ;
        Class<?> clz = o.getClass();
        Field[] fields = clz.getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        for(Field f :fields){
            f.setAccessible(true);
            Object o1 = null;
            try {
                o1 = f.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(o1==null) {
                continue;
            }
            if(CharSequence.class.isAssignableFrom(f.getType()) ){
                hql.append(" and ").append( f.getName()).append(" like :"+f.getName());
                hql1.append(" and ").append( f.getName()).append(" like :"+f.getName());
                map.put(f.getName(), o1+"%");
            }else{
                hql.append(" and ").append( f.getName()).append(" = :"+f.getName());
                hql1.append(" and ").append( f.getName()).append(" = :"+f.getName());
                map.put(f.getName(), o1);
            }
        }

        Session session = HibernateUtil.getTransactionSession();
        Query query = session.createQuery(hql.toString());
        map.forEach((k,v)->{
            query.setParameter(k,v);
        });
        Number result = (Number) query.getSingleResult();

        int total = result.intValue();

        PageRes pageRes = new PageRes();
        pageRes.setTotal(total);
        pageRes.setPageSize(pageSize);
        pageRes.setCurPage(curPage);
        pageRes.setTotalPage(total%pageSize==0?total/pageSize:total/pageSize+1);


        Query query1 = session.createQuery(hql1.toString());
        map.forEach((k,v)->{
            query1.setParameter(k,v);
        });
        query1.setFirstResult((curPage-1)*pageSize);
        query1.setMaxResults(pageSize);
        List data = query1.getResultList();

        HibernateUtil.close(session);
        pageRes.setData(data);
        return pageRes;
    }

}
