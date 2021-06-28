package com.study.liyi.hibernate.test.Hibernate3;

import com.study.liyi.hibernate.entity.entity3.Department3;
import com.study.liyi.hibernate.entity.entity3.Manager3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/25 16:33  星期五
 */
public class HibernateTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;


    @Before
    public void init(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure().build();

        sessionFactory = configuration.buildSessionFactory(standardRegistry);

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    public void testSave(){
        Department3 department=new Department3();
        department.setDeptName("DEPT-AA");

        Manager3 manager=new Manager3();
        manager.setMgrName("MGR-AA");

        //设定关联关系
        department.setMgr(manager);
        manager.setDept(department);

        //保存   先保存没有外键列的对象,能减少UPDATE语句
        session.save(manager);
        session.save(department);
    }

    @Test
    public void testGet(){
        Department3 department=session.get(Department3.class,1);

    }









}
