package com.liyi.study.jdbc.day0427.test;

import com.liyi.study.jdbc.day0427.bean.Order;
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
 * @time: 2021/4/27 23:32  星期二
 */
public class OrderForQuery {

    public Order orderForQuery(String sql,Object...args) {
        Connection con= null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();

            ps = con.prepareStatement(sql);

            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Order order=new Order();
                for (int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);

                }
                return order;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps,rs);
        }
        return null;



    }


    @Test
    public void test(){
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id=?";

        Order order = orderForQuery(sql, 1);
        System.out.println(order);

    }


}
