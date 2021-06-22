package com.study.cms.comm.utils;

import com.study.cms.comm.anno.MyColumn;
import com.study.cms.comm.anno.MyTableName;
import com.study.cms.comm.anno.MyTransient;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.User;

import java.lang.reflect.Field;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/20 22:54  星期日
 */
public class SqlUtils {

    public static void main(String[] args) {
        String sql = getSelectSql(User.class);
        String sql1 = getSelectSql(Dept.class);
    }

    //获得查询的sql
    public static String getSelectSql(Class<?> clz){
        StringBuilder sb = new StringBuilder();
        sb.append("select ");

        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

            MyTransient myTransient = fields[i].getAnnotation(MyTransient.class);
            if(myTransient!=null){
                continue;
            }

            MyColumn myColumn = fields[i].getAnnotation(MyColumn.class);
            if(myColumn !=null && !StringUtils.isEmpty(myColumn.value())){
                sb.append(myColumn.value());
            }else{
                sb.append(fields[i].getName());
            }


            if( i<fields.length-1){
                sb.append(",");
            }
        }
        sb.append(" from ");
        MyTableName annotation = clz.getAnnotation(MyTableName.class);
        String tableName = null;
        if(annotation!=null){
            tableName = annotation.value();
        }else{
            tableName = clz.getSimpleName();
        }
        sb.append(tableName);
        System.out.println(sb);
        return sb.toString();
    }

    public static String getInsertSql(Object o){
        return null;
    }

    public static String getUpdateSql(Object o){//Dept
        String sql ="update table set aaa=?  ,aaa=? where id=?";

        return null;
    }



    public static String getDeleteSql(Class<?> clz){//Dept

        return null;
    }

}
