package com.liyi.study.jdbc.day0429.dao;

import com.liyi.study.jdbc.day0428.bean.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 23:13  星期三
 */
public interface CustomerDAO {
    void insert(Connection con, com.liyi.study.jdbc.day0429.bean.Customer cust);

    /**
     * 将cust对象添加到数据库中
     */
    void insert(Connection con, Customer cust);

    /**
     * 针对指定的id删除表中的一条记录
     */
    void deleteById(Connection con,int id);

    /**
     * 针对内存中的cust对象，去修改数据库中的指定记录
     */
    void updateById(Connection con,Customer cust);

    /**
     * 针对指定的id查询数据库中的一条Customer记录
     * @param con
     * @param id
     * @return
     */
    Customer getCustomerById(Connection con, int id);


    /**
     * 查询Customer表中的所有记录
     * @return
     */
    List<Customer> getAll(Connection con);

    /**
     * 返回数据表中的数据的条目数
     * @param con
     * @return
     */
    Long getCount(Connection con);

    /**
     * 返回数据表中最大的生日
     * @param con
     * @return
     */
    Date getMaxBirth(Connection con);


}
