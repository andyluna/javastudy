package com.liyi.study.jdbc.day0427.test;

import com.liyi.study.jdbc.day0427.bean.Customer;
import com.liyi.study.jdbc.day0427.bean.Order;
import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 0:08  星期三
 */


/**
 * 针对不同表的查询 返回一条记录
 */
public class PreparedStatementQueryTest {
    public <T> T getInstance(Class<T> clazz,String sql,Object... args){
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
                T t=clazz.newInstance();
                for (int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);

                }
                return t;
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

        String sql="select id,name,email from customers where id=?";
        Customer customer = getInstance(Customer.class, sql,1);
        System.out.println(customer);

    }




    public <T> List<T> getForList(Class<T> clazz,String sql,Object... args){
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

            //创建集合对象
            ArrayList<T> list = new ArrayList<>();


            while (rs.next()){
                T t=clazz.newInstance();

                //处理每一行数据中的每一个列：给t对象指定的属性赋值
                for (int i=0;i<columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);

                }
                list.add(t);

            }
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps,rs);
        }
        return null;
    }



    @Test
    public void test1(){
        String sql="select id,name,email from customers where id<?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        list.forEach(System.out::println);

    }


}


