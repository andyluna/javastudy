package com.study.liyi.hibernate.test.Hibernate4;


import com.study.liyi.hibernate.entity.entity4.Category;
import com.study.liyi.hibernate.entity.entity4.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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




    @Test
    public void testSave(){
        Category category1=new Category();
        category1.setName("C-AA");
        Category category2=new Category();
        category2.setName("C-BB");

        Item item1=new Item();
        item1.setName("I-AA");
        Item item2=new Item();
        item1.setName("I-BB");

        category1.getItems().add(item1);
        category1.getItems().add(item2);
        category2.getItems().add(item1);
        category2.getItems().add(item2);

        item1.getCategories().add(category1);
        item1.getCategories().add(category2);
        item2.getCategories().add(category1);
        item2.getCategories().add(category2);

        session.save(category1);
        session.save(category2);
        session.save(item1);
        session.save(item2);

    }


    @Test
    public void testGet(){
        Category category=session.get(Category.class,1);
        System.out.println("categoryName : "+category.getName());

        Set<Item> items=category.getItems();
        System.out.println("items.size : "+items.size());
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }










}
