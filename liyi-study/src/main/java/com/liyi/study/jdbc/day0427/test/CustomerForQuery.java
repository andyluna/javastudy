package com.liyi.study.jdbc.day0427.test;

import com.liyi.study.jdbc.day0427.bean.Customer;
import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/27 22:24  星期二
 */
public class CustomerForQuery {


    //针对Customer表的查询
    public Customer queryForCustomers(String sql, Object...args) {

        Connection con= null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        try {
            con = JDBCUtils.getConnection();

            ps = con.prepareStatement(sql);

            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //通过rsmd获取结果集的列数
            int columnCount=rsmd.getColumnCount();
            if (rs.next()){
                Customer cust=new Customer();

                for (int i=0;i<columnCount;i++){
                    //获取每个列的值
                    Object columnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    String columnName =rsmd.getColumnName(i+1);

                    //给cust对象指定的columnName属性赋值为columnValue，通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust,columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            JDBCUtils.closeResource(con,ps,rs);
        }


        return null;


    }


    @Test
    public void test(){
        String sql="select id,name,email,birth from customers where id=?";
        Customer customer=queryForCustomers(sql,13);
        System.out.println(customer);
    }
}
