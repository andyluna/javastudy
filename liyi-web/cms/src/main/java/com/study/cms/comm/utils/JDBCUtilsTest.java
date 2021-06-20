package com.study.cms.comm.utils;

import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/20 22:28  星期日
 */
public class JDBCUtilsTest {

    public static void main(String[] args) {

        List<User> users = test1(User.class);
        for (User user:users){
            System.out.println(user);
        }


        List<Dept> depts = test1(Dept.class);
        for (Dept user:depts){
            System.out.println(user);
        }
    }

    //从类里面 查找一个方法
    public static Method findMethod(Class<?> clz,String methodName){
        Method[] methods = clz.getDeclaredMethods();
        Method method = null;
        for(Method m:methods){
            if(m.getName().equals(methodName)){
                method = m;
                break;
            }
        }
        return method;
    }




        public static <T> List<T> test1(Class<T> clz) {
        Connection con = null;
        //查询数据库
        Statement stmt = null;
        ResultSet resultSet = null;
        List<T> resList = null;
        try {
            //1.获取连接
            con = JDBCUtils.getCon();
            //2.准备一条sql语句
            String sql = SqlUtils.getSelectSql(clz);

            //3.创建一个执行器
            stmt = con.createStatement();

            //4.调用执行器的  调用查询方法   得到一个结果集
            resultSet = stmt.executeQuery(sql);
            resList = new ArrayList<>();
            //5.解析结果集
            int n =0;
            while(resultSet.next()){
                n++;
                T t = clz.newInstance();//利用反射创建 一个对象  跟new User()
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                System.out.println("当前行 总共有多少列数据 "+columnCount); //8
                for (int i = 1; i < columnCount+1; i++) {
                    String columnName = metaData.getColumnName(i);//列名
                    int    columnType = metaData.getColumnType(i);//列的数据类型 编码
                    String typeName   = metaData.getColumnTypeName(i);//列的数据类型 编码对应的名称
                    String columnLabel = metaData.getColumnLabel(i);//列的标签名称
                    String tableName = metaData.getTableName(i);//当前列所来源的表
                    String methodName ="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);//得到一个属性对应的set 方法名
                    Method method = findMethod(clz, methodName);
                    Object rs = null;
                    if(columnType==4){// int
                        rs = resultSet.getInt(columnName);
                    }else if(columnType==12){//
                        rs = resultSet.getString(columnName);
                    }
                    method.invoke(t,rs);
                }
                resList.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            JDBCUtils.close(con,stmt,resultSet);

        }

        return resList;
    }

    public static void test2() {
        Connection con = null;
        //查询数据库
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            con = JDBCUtils.getCon();
            //2.准备一条sql语句
            String sql = "select id,name,username,phone,password,address,sex,dept_id from c_user ";

            //3.创建一个执行器
            stmt = con.createStatement();

            //4.调用执行器的  调用查询方法   得到一个结果集
            resultSet = stmt.executeQuery(sql);
            List<User> users = new ArrayList<>();
            //5.解析结果集
            while(resultSet.next()){
                //这里的代码 就是调用结果集里面的方法获取具体的结果
                Integer id      = resultSet.getInt(1);
                String name     = resultSet.getString("name");
                String username = resultSet.getString("username");
                String phone    = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String address  = resultSet.getString("address");
                Integer sex     = resultSet.getInt("sex");
                Integer deptId  = resultSet.getInt("dept_id");

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setUsername(username);
                user.setPhone(phone);
                user.setPassword(password);
                user.setAddress(address);
                user.setSex(sex);
                user.setDept_id(deptId);


                System.out.println("当前 查询的用户  = "+user);
                users.add(user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,stmt,resultSet);
        }


    }


}
