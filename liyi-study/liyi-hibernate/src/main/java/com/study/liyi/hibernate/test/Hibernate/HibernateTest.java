package com.study.liyi.hibernate.test.Hibernate;

import com.study.liyi.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

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
    public void testDoWork(){
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection);
            }
        });
    }


    @Test
    public void testSessionFlush(){
        User user=new User();
        user.setName("test9527");
        user.setUsername("test9527");
        user.setPassword("123");
        user.setPhone("12345678911");
        user.setDeptId(001);
        Serializable save = session.save(user);
        System.out.println(save);

    }


    @Test
    public void testRefresh(){
        User user=session.get(User.class,1);
        System.out.println(user);

        session.refresh(user);
        System.out.println(user);
    }


    @Test
    public void testClear(){
        User user=session.get(User.class,1);

        session.clear();
        User user1=session.get(User.class,1);
    }


    @Test
    public void testPersist(){
        User user=new User();
        user.setName("test9527");
        user.setUsername("test9527");
        user.setPassword("123");
        user.setPhone("12345678911");
        user.setDeptId(001);
        user.setId(0555);

        session.persist(user);//不会执行insert 会抛出一个异常
    }


    @Test
    public void testLoad(){//延迟检索
        User user=session.load(User.class,1);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){//无论要更新的游离对象是否跟数据表中的数据一致,都会发送update语句
        User user=session.get(User.class,800);

        transaction.commit();
        session.close();

//        user.setId(999);

        session=sessionFactory.openSession();
        transaction=session.beginTransaction();

        User user1=session.get(User.class,800);

        session.update(user);
    }


    @Test
    public void testSaveOrUpdate(){
        User user=new User(null,"test001","123","15815815811","name001","湖南",0,1);

        //有id表中有记录时执行save
        //若id不为空,但数据表中没有对应的记录,抛异常
        user.setId(800);

        session.saveOrUpdate(user);

    }


    @Test
    public void testDelete(){//id和数据库表中的一条记录对应,没有抛出异常
//        User user=new User();
//        user.setId(1523);

        //可以通过设置配置文件 使其删除对象后把其OID置为null
        User user=session.get(User.class,950);
        session.delete(user);

        System.out.println(user);

    }

    @Test
    public void testEvict(){//从session缓存中把指定的持久化对象移除  缓存中未被evict()方法移除的对象会调用update()
        User user1=session.get(User.class,984);
        User user2=session.get(User.class,985);

        user1.setUsername("testUser1");
        user2.setUsername("test985");

        session.evict(user2);

    }






}
