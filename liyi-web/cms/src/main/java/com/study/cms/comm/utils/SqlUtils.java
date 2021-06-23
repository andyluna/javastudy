package com.study.cms.comm.utils;

import com.study.cms.comm.anno.MyColumn;
import com.study.cms.comm.anno.MyId;
import com.study.cms.comm.anno.MyTableName;
import com.study.cms.comm.anno.MyTransient;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/20 22:54  星期日
 */
public class SqlUtils {

    public static void main(String[] args) {
        String sql = getSelectSql(User.class);
//        String sql1 = getSelectSql(Dept.class);
//
        Dept dept = new Dept();
        dept.setName("开发部");
        dept.setCode("002");
        getInsertSql(dept);
         getUpdateSql(dept);
        getDeleteSqlById(User.class);
        getDeleteSql(dept);


//
    }


    //获得查询的sql
    public static SqlAndParam getSelectSql(Object o) {
        SqlAndParam sap = new SqlAndParam();
        Class<?> clz = o.getClass();
        sap.setReturnType(clz);
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null) {
                continue;
            }
            sb.append(getColumnName(fields[i]));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" from ");
        sb.append(gettableName(clz));
        sb.append(" where 1=1 ");



        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null ) {
                continue;
            }
            //主键不更新
            Class<?> type = fields[i].getType();
            fields[i].setAccessible(true);
            Object value = getValue(fields[i], o);
            if (value == null || (CharSequence.class.isAssignableFrom(type) && StringUtils.isEmpty(value))) {
                continue;
            }
            sb.append(" and  ").append(getColumnName(fields[i])).append(" = ?");

            sap.addParam(value);
        }

        System.out.println("getSelectSql ="+sb);
        sap.setSql(sb.toString());
        return sap;
    }



    //获得查询的sql
    public static String getSelectSql(Class<?> clz) {
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null) {
                continue;
            }
            sb.append(getColumnName(fields[i]));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" from ");
        sb.append(gettableName(clz));
        System.out.println("getSelectSql ="+sb);
        return sb.toString();
    }


    public static SqlAndParam getInsertSql(Object o) {
        SqlAndParam sap = new SqlAndParam();
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ");
        //获取类对应的表名
        sb.append(gettableName(o.getClass())).append("(");
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null) {
                continue;
            }
            Class<?> type = fields[i].getType();
            fields[i].setAccessible(true);
            Object value = getValue(fields[i], o);
            if (value == null || (CharSequence.class.isAssignableFrom(type) && StringUtils.isEmpty(value))) {
                continue;
            }
            sb.append(getColumnName(fields[i]));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        sb.append("values(");
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null) {
                continue;
            }
            Class<?> type = fields[i].getType();
            fields[i].setAccessible(true);
            Object value = getValue(fields[i], o);
            if (value == null || (CharSequence.class.isAssignableFrom(type) && StringUtils.isEmpty(value))) {
                continue;
            }
            sb.append("?");
            sb.append(",");
            sap.addParam(value);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");

        System.out.println("getInsertSql ="+sb);
        sap.setSql(sb.toString());
        return sap;
    }

    public static SqlAndParam getUpdateSql(Object o) {//Dept
        SqlAndParam sap = new SqlAndParam();
        StringBuilder sb = new StringBuilder();
        sb.append("update ");
        //获取类对应的表名
        sb.append(gettableName(o.getClass())).append(" set ");

        Field[] fields = o.getClass().getDeclaredFields();
        String idColumnName = getIdColumnName(o.getClass());
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null || fields[i].getName().equals(idColumnName)) {
                continue;
            }
            //主键不更新
            Class<?> type = fields[i].getType();
            fields[i].setAccessible(true);
            Object value = getValue(fields[i], o);
            if (value == null || (CharSequence.class.isAssignableFrom(type) && StringUtils.isEmpty(value))) {
                continue;
            }
            sb.append(getColumnName(fields[i]));
            sap.addParam(value);
            sb.append("=?");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" where " + idColumnName + "=?");
        sap.addParam(getIdColumnValue(o));
        System.out.println("getUpdateSql ="+sb);
        sap.setSql(sb.toString());
        return sap;
    }


    public static SqlAndParam getDeleteSqlById(Class<?> clz) {//Dept
        StringBuilder sb = new StringBuilder();
        sb.append("delete from ");
        //获取类对应的表名
        MyTableName annotation = clz.getAnnotation(MyTableName.class);
        String tableName = null;
        if (annotation != null) {
            tableName = annotation.value();
        } else {
            tableName = clz.getSimpleName();
        }
        sb.append(tableName).append(" where " + getIdColumnName(clz) + "=?");
        System.out.println("getDeleteSqlById ="+sb);
        SqlAndParam sap = new SqlAndParam(sb.toString());
        return sap;
    }

    public static SqlAndParam getDeleteSql(Object o) {//Dept
        SqlAndParam sap = new SqlAndParam();
        StringBuilder sb = new StringBuilder();
        sb.append("delete from ");
        //获取类对应的表名
        Class<?> clz = o.getClass();
        sb.append(gettableName(clz)).append(" where   ");
        //设置要修改的字段
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if (myTransient != null) {
                continue;
            }
            Class<?> type = fields[i].getType();
            fields[i].setAccessible(true);
            Object value = getValue(fields[i], o);
            if (value == null || (CharSequence.class.isAssignableFrom(type) && StringUtils.isEmpty(value))) {
                continue;
            }
            sb.append(" "+getColumnName(fields[i])).append("=? and");
            sap.addParam(value);
        }

        sb.delete(sb.length()-3,sb.length());

        System.out.println("getDeleteSql ="+sb);
        sap.setSql(sb.toString());
        return sap;
    }

    private static <T> String gettableName(Class<T> clz) {
        MyTableName annotation = clz.getAnnotation(MyTableName.class);
        String tableName = null;
        if (annotation != null) {
            return annotation.value();
        } else {
            return clz.getSimpleName();
        }
    }

    private static String getColumnName(Field field) {
        MyColumn myColumn = field.getAnnotation(MyColumn.class);
        if (myColumn != null && !StringUtils.isEmpty(myColumn.value())) {
            return myColumn.value();
        } else {
            return field.getName();
        }
    }

    private static <T> String getIdColumnName(Class<T> clz) {
        MyId myId = clz.getAnnotation(MyId.class);
        if (myId != null && !StringUtils.isEmpty(myId.value())) {
            return myId.value();
        } else {
            return clz.getDeclaredFields()[0].getName();
        }
    }
    private static  Object getIdColumnValue(Object o) {
        String name = getIdColumnName(o.getClass());
        Field field = null;
        try {
            field = o.getClass().getDeclaredField(name);
            field.setAccessible(true);
            Object res = field.get(o);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static Object getValue(Field field, Object o) {
        Class<?> type = field.getType();
        Object value = null;
        try {
            return field.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
