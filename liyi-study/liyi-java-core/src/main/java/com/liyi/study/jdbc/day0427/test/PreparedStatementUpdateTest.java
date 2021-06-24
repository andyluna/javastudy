package com.liyi.study.jdbc.day0427.test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/27 20:53  星期二
 */

import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 使用PreparedStatement实现对数据表的增删改操作
 */
public class PreparedStatementUpdateTest {
    //向customer表中添加一条记录
    @Test
    public void testInsert(){
        Connection connection = null;
        PreparedStatement ps= null;
        try {
            //读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros=new Properties();
            pros.load(is);

            String user=pros.getProperty("user");
            String password=pros.getProperty("password");
            String url=pros.getProperty("url");
            String driverClass=pros.getProperty("driverClass");

            //加载驱动
            Class.forName(driverClass);

            //获取连接
            connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);

            //预编译sql语句，返回PreparedStatement的实例
            String sql="insert into customers(name,emil,birth)values(?,?,?)";
            ps = connection.prepareStatement(sql);

            //填充占位符
            ps.setString(1,"哪吒");
            ps.setString(2,"nezha@gmail.com");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD");
            Date date = sdf.parse("1000-01-01");
            ps.setDate(3,new java.sql.Date(date.getTime()));

            //执行Sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }


    public void testUpdate(){
        Connection connection= null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql="update customers set name =? where id=?";
            ps = connection.prepareStatement(sql);

            ps.setObject(1,"莫扎特");
            ps.setObject(2,18);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps);
        }

    }





    //通用的增删改
    public void testUpdate(String sql,Object ...args) {
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con = JDBCUtils.getConnection();

            ps = con.prepareStatement(sql);

            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(con,ps);
        }
    }


    @Test
    public void testCommonUpdateTest(){
        String sql="delete from customers where id=?";
        testUpdate(sql,3);


    }






}
