package com.liyi.study.jdbc.day0428.test;

import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import com.liyi.study.jdbc.day0428.bean.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 9:22  星期三
 */
public class PreparedStatementTest {

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



    // 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
    //如何避免出现sql注入：只要用 PreparedStatement(从Statement扩展而来) 取代 Statement
    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();
        //SELECT user,password FROM user_table WHERE user = '1' or ' AND password = '=1 or '1' = '1'
        String sql = "SELECT user,password FROM user_table WHERE user=? and password=? ";
        User returnUser = getInstance(User.class, sql,user,password);
        if(returnUser != null){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名不存在或密码错误");
        }
    }




}
