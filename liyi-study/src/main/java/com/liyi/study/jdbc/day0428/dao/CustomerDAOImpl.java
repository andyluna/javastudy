package com.liyi.study.jdbc.day0428.dao;

import com.liyi.study.jdbc.day0428.bean.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 23:23  星期三
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO{
    @Override
    public void insert(Connection con, Customer cust) {
        String sql="insert into customers(name,email,birth)values(?,?,?)";

        update(con,sql,cust.getName(),cust.getEmail(),cust.getBirth());

    }

    @Override
    public void deleteById(Connection con, int id) {

        String sql="delete from customer where id=?";
        update(con,sql,id);
    }

    @Override
    public void updateById(Connection con, Customer cust) {
        String sql="update customers set name=?,email=?,birth=? where id=?";
        update(con,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());

    }

    @Override
    public Customer getCustomerById(Connection con, int id) {
        String sql="selete id,name,email,birth from customers where id=?";
        Customer customer = getInstance(con, Customer.class, sql, id);
        return customer;

    }

    @Override
    public List<Customer> getAll(Connection con) {
        String sql="selete id,name,email,birth from customers";
        List<Customer> list=getForList(con,Customer.class,sql);
        return list;
    }

    @Override
    public Long getCount(Connection con) {
        String sql="selete count(*) from customers";
        return getValue(con,sql);
    }

    @Override
    public Date getMaxBirth(Connection con) {
        String sql="selete max(birth) from customers";
        return getValue(con,sql);
    }
}
