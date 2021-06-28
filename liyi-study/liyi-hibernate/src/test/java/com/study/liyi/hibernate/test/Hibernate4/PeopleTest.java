package com.study.liyi.hibernate.test.Hibernate4;

import com.study.liyi.hibernate.entity.entity4.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @time: 2021/6/28 六月 10:29
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class PeopleTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    // 你一定要用我的代码 来创建 sessionFactory 啊
    //这是Hibernate5   视频里的老师是以前的就版本  他们创建会有问题的
    @Before
    public void init(){
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate4.cfg.xml").build();


        Metadata metadata = new MetadataSources( standardRegistry ).buildMetadata();
        this.sessionFactory = metadata.buildSessionFactory();
        session = this.sessionFactory.openSession();
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
        People people = new People();
        people.setName("李逸");
        people.setSfzh("43123123123123");
        people.setBirthDay(new Date());
        people.setAddress("长沙市天心区");
        people.setCreateId(1);
        people.setCreateDate(new Date());
        people.setFavor("打球");

        session.save(people);
    }
}
