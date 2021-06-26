package com.study.liyi.hibernate.test.Hibernate2;

import com.study.liyi.hibernate.entity.entity1.Customer;
import com.study.liyi.hibernate.entity.entity1.Order;
import com.study.liyi.hibernate.entity.entity2.Department;
import com.study.liyi.hibernate.entity.entity2.Manager;
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
        Department department=new Department();
        department.setDeptName("DEPT-AA");

        Manager manager=new Manager();
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
        //默认情况对关联属性使用懒加载,
        Department department=session.get(Department.class,1);
        System.out.println("DeptName : "+department.getDeptName());

        //可能会出现懒加载异常的问题
//        session.close();
//        Manager mgr=department.getMgr();
//        System.out.println(mgr.getMgrName());

        Manager mgr=department.getMgr();
        System.out.println("MgrName : "+mgr.getMgrName());
    }

    @Test
    public void testGet2(){
        //再查询没有外键的实体对象时,使用左外连接查询,
        //一并查询出其关联的对象,并进行初始化
        Manager manager=session.get(Manager.class,1);
        System.out.println(manager.getMgrName());
        System.out.println(manager.getDept().getDeptName());
    }








}
