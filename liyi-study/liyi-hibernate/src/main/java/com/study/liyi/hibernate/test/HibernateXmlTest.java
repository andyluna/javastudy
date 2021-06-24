package com.study.liyi.hibernate.test;

import com.study.liyi.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/24 23:26  星期四
 */
public class HibernateXmlTest {
    public static void main(String[] args) {
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder()
                        .configure().build();

        Metadata metadata = new MetadataSources( standardRegistry ).buildMetadata();
        //1.创建SessionFactory 工厂
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        //2.创建session
        Session session = sessionFactory.openSession();

        //3.用创建好的session 开启一个事务
        Transaction transaction = session.beginTransaction();

        //4.做具体的数据增删改查操作
        User user = session.get(User.class, 2);

        System.out.println(user);

        //5结束操作 关闭事务
        transaction.commit();

        //6.关闭 session
        session.close();

        //7.关闭 sessionFactory 工厂
        sessionFactory.close();
    }
}
