package com.study.liyi.mybatis;

import com.study.liyi.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @time: 2021/6/28 六月 09:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MybatisMain {
    private static final Logger log = LoggerFactory.getLogger(MybatisMain.class);
    public static void main(String[] args) throws IOException {
        //1.准备Mybatis的配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);


        //3.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            //4.执行sql操作
//            sqlSession.selectOne();

            log.debug("执行成功,开始提交");
        }catch (Exception e){
            log.debug("执行出错,开始回滚",e);
            sqlSession.rollback();
        }

        //5.关闭 sqlSession
        sqlSession.close();

        //6.关闭SqlSessionFactory

    }

}
