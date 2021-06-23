package com.study.cms.comm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/23 23:41  星期三
 */
public class SqlAndParam {
    private String sql;
    private List<Object> param;
    private Class<?> returnType;

    public SqlAndParam() {
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public SqlAndParam(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Object> getParam() {
        return param;
    }

    public Object[] getParamArray() {
        return param!=null?param.toArray(new Object[]{}):null;
    }

    public void addParam(Object  p) {
        if(this.param == null){
            this.param = new ArrayList<>();
        }
        this.param.add(p);
    }

    public void setParam(List<Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "SqlAndParam{" +
                "sql='" + sql + '\'' +
                ", param=" + param +
                ", returnType=" + returnType +
                '}';
    }
}
