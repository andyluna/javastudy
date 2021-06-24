package com.liyi.study.jdbc.day0428.test;

import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 22:17  星期三
 */
public class TransactionTest {


    //通用的查询操作，用于返回数据库表中的一条数据(考虑事务)
    public <T> T getInstance(Connection con,Class<T> clazz,String sql,Object... args){

        PreparedStatement ps= null;
        ResultSet rs = null;
        try {


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
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;

    }

    @Test
    public void test() throws Exception {
        Connection con=JDBCUtils.getConnection();
        String sql="select user,password,balance from user_table where user=?";

        //获取当前连接的隔离级别
        int transactionIsolation = con.getTransactionIsolation();
        System.out.println(transactionIsolation);

        //设置数据库的隔离级别  读已提交
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        //取消自动提交数据
        con.setAutoCommit(false);



        User user = getInstance(con, User.class, sql, "CC");
        System.out.println(user);

    }




}
