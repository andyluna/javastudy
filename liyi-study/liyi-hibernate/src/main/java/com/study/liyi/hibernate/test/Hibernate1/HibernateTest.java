package com.study.liyi.hibernate.test.Hibernate1;

import com.study.liyi.hibernate.entity.entity1.Customer;
import com.study.liyi.hibernate.entity.entity1.Order;
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
    public void testMany2One(){
        Customer customer=new Customer();
        customer.setCustomerName("sss");

        Order order1=new Order();
        order1.setOrderName("ORDER-1");
        Order order2=new Order();
        order2.setOrderName("ORDER-2");

        //设定关联关系
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        //执行save操作
        session.save(customer);
        session.save(order1);
        session.save(order2);
    }


    @Test
    public void testMany2OneGet(){
        Order order=session.get(Order.class,1);
        System.out.println(order.getOrderName());
    }

    @Test
    public void testDelete(){
        Customer customer=session.get(Customer.class,1);
        session.delete(customer);
    }









}
