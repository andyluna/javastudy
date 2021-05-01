package com.liyi.study.jdbc.day0430.dbutils;

import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import com.liyi.study.jdbc.day0429.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/29 23:52  星期四
 */
public class QueryRunnerTest {


    @Test
   public void testInsert(){
        Connection con = null;
        try {
            QueryRunner runner=new QueryRunner();
            con = JDBCUtils.getConnection();
            String sql="insert into customers(name,email,birth)value(?,?,?)";
            int update = runner.update(con, sql, "蔡徐坤", "cai@qq.com", "1999-12-04");
            System.out.println("添加了"+update+"记录");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,null);
        }
    }

    @Test
    public void testQuery1() throws Exception{
        QueryRunner runner=new QueryRunner();
        Connection con = JDBCUtils.getConnection();
        String sql="select id,name,email,birth from customers where id=?";

        BeanHandler<Customer> handler=new BeanHandler<>(Customer.class);

        Customer cust = runner.query(con, sql, handler, 1);
        System.out.println(cust);
    }

    @Test
    public void testQuery2() throws Exception{
        QueryRunner runner=new QueryRunner();
        Connection con = JDBCUtils.getConnection();
        String sql="select id,name,email,birth from customers where id<?";

        BeanListHandler<Customer> handler=new BeanListHandler<>(Customer.class);
        List<Customer> customerList = runner.query(con, sql, handler, 20);
        customerList.forEach(System.out::println);
    }


    /**
     * 自定义ResultSetHandler的实现类
     */
    @Test
    public void testQuery3(){
        Connection con=null;
        try {
            QueryRunner runner=new QueryRunner();
            con = JDBCUtils.getConnection();

            String sql="select id,name,email,birth from customers where id=?";
            ResultSetHandler<Customer> handler=new ResultSetHandler<Customer>(){

                @Override
                public Customer handle(ResultSet rs) throws SQLException {
                    if (rs.next()){
                        int id=rs.getInt("id");
                        String name=rs.getString("name");
                        String email=rs.getString("email");
                        Date birth=rs.getDate("birth");
                        Customer cust=new Customer(id,name,email,birth);
                        return cust;
                    }
                    return null;
                }
            };
            Customer customer=runner.query(con,sql,handler,1);
            System.out.println(customer);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(con,null);
        }
    }
}
