package com.study.cms.comm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 22:04  星期二
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static{
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources( standardRegistry ).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }

    public static Session getTransactionSession(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }


    public static void close(Session session){
        if(session!=null){
            session.close();
        }
    }



}
