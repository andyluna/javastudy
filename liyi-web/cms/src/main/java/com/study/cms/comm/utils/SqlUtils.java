package com.study.cms.comm.utils;

import com.study.cms.comm.anno.MyTableName;
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
    }

    //获得查询的sql
    public static String getSelectSql(Class<?> clz){
        StringBuilder sb = new StringBuilder();
        sb.append("select ");

        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if( i== fields.length-1){
                sb.append(fields[i].getName());
            }else{
                sb.append(fields[i].getName()).append(",");
            }

        }

        sb.append(" from ");
        MyTableName annotation = clz.getAnnotation(MyTableName.class);
        String tableName = null;
        if(annotation!=null){
            tableName = annotation.tableName();
        }else{
            tableName = clz.getSimpleName();
        }
        sb.append(tableName);
        System.out.println(sb);
        return sb.toString();
    }

}
