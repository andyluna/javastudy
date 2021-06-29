package com.study.cms.comm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 22:05  星期二
 */
public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;
    static{
        try {
        //1.准备Mybatis的配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建sqlSessionFactory
        sessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        //6.关闭SqlSessionFactory
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }


    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

    public static SqlSession getSession(boolean autoCommit){
        return sessionFactory.openSession(autoCommit);
    }

    public static void close(SqlSession session){
        if(session!=null){
            session.close();
        }
    }


}
