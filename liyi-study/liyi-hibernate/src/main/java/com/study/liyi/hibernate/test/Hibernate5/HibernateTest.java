package com.study.liyi.hibernate.test.Hibernate5;


import com.study.liyi.hibernate.entity.entity5.Person;
import com.study.liyi.hibernate.entity.entity5.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

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


    /**
     * 插入
     * 1.对于子类对象只需要把记录插入到一张数据表中
     * 2.辨别者列有Hibernate自动维护
     */
    @Test
    public void testSave(){
        Person person=new Person();
        person.setName("AA");
        person.setAge(11);

        session.save(person);

        Student student=new Student();
        student.setAge(22);
        student.setName("BB");
        student.setSchool("理工");

        session.save(student);
    }


    /**
     * 缺点:
     * 1. 使用了辨别者列.
     * 2. 子类独有的字段不能添加非空约束.
     * 3. 若继承层次较深, 则数据表的字段也会较多.
     */

    /**
     * 查询:
     * 1. 查询父类记录, 只需要查询一张数据表
     * 2. 对于子类记录, 也只需要查询一张数据表
     */
    @Test
    public void testQuery(){
//        List<Person> persons = session.createQuery("FROM Person").list();
//        System.out.println(persons.size());
//
//        List<Student> stus = session.createQuery("FROM Student").list();
//        System.out.println(stus.size());
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }










}
