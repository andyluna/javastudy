package com.liyi.study.jdbc.day0428.test;


import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import com.liyi.study.jdbc.day0428.bean.Customer;
import com.liyi.study.jdbc.day0428.dao.CustomerDAOImpl;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/29 10:46  星期四
 */
class CustomerDAOImplTest {

    private CustomerDAOImpl dao=new CustomerDAOImpl();



    @Test
    void insert() {

        Connection con= null;
        try {
            con = JDBCUtils.getConnection();
            Customer customer = new Customer(1, "大哥", "Dage126.com", new Date(464444L));
            dao.insert(con,customer);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }

    }

    @Test
    void deleteById() {
        Connection con= null;

        try {
            con = JDBCUtils.getConnection();
            dao.deleteById(con,20);
            System.out.println("删除成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }


    }

    @Test
    void updateById() {
        Connection con= null;
        try {
            con = JDBCUtils.getConnection();
            Customer customer=new Customer(18,"贝没芬","1999@qq.com",new Date(54544545L));

            dao.updateById(con,customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }

    }

    @Test
    void testGetCustomerById() {
        Connection con= null;
        try {
            con = JDBCUtils.getConnection();

            Customer customer = dao.getCustomerById(con,1);
            System.out.println(customer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }
    }

    @Test
    void getAll() {
        Connection con= null;
        try {
            con = JDBCUtils.getConnection();
            List<Customer> list=dao.getAll(con);
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }
    }

    @Test
    void getCount() {
        Connection con= null;
        try {
            con = JDBCUtils.getConnection();
            Long count = dao.getCount(con);
            System.out.println("表中有:"+count+"条数据");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }
    }

    @Test
    void getMaxBirth() {
        Connection con= null;
        try {
            con = JDBCUtils.getConnection();
            java.util.Date maxBirth = dao.getMaxBirth(con);
            System.out.println(maxBirth);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);

        }
    }
}