package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.comm.utils.SqlAndParam;
import com.study.cms.comm.utils.SqlUtils;
import com.study.cms.comm.vo.PageRes;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/23 23:36  星期三
 */
public class CommonDaoEnhanceIdbcImpl extends CommonDaoJdbcImpl implements CommonDaoEnhance {
    @Override
    public int update(Object o) {
        return super.updateBySqlAndParam(SqlUtils.getUpdateSql(o));
    }

    @Override
    public int insert(Object o) {
        SqlAndParam sqlAndParam = SqlUtils.getInsertSql(o);
        return super.updateBySqlAndParam(sqlAndParam);
    }

    @Override
    public <T> int deleteById(Class<T> clz, Object id) {
        SqlAndParam sqlAndParam = SqlUtils.getDeleteSqlById(clz);
        sqlAndParam.addParam(id);
        return  super.updateBySqlAndParam(sqlAndParam);
    }

    @Override
    public int delete(Object o) {
        SqlAndParam sqlAndParam = SqlUtils.getDeleteSql(o);
        return super.updateBySqlAndParam(sqlAndParam);
    }

    @Override
    public <T> List<T> selectList(Object o) {
        SqlAndParam sqlAndParam = SqlUtils.getSelectSql(o);
        String sql = sqlAndParam.getSql();
        Class<T>  returnType = (Class<T>) sqlAndParam.getReturnType();
        Object[] param = sqlAndParam.getParamArray();
        return super.selectList(sql,returnType,param);
    }

    @Override
    public <T> T selectOne(Object o) {
        SqlAndParam sqlAndParam = SqlUtils.getSelectSql(o);
        String sql = sqlAndParam.getSql();
        Class<T>  returnType = (Class<T>) sqlAndParam.getReturnType();
        Object[] param = sqlAndParam.getParamArray();
        return super.selectOne(sql,returnType,param);

    }

    @Override
    public <T> PageRes selectPage(Object o, Integer curPage, Integer pageSize) {
        SqlAndParam sqlAndParam = SqlUtils.getSelectSql(o);
        String sql = sqlAndParam.getSql();
        Class<T>  returnType = (Class<T>) sqlAndParam.getReturnType();
        Object[] param = sqlAndParam.getParamArray();
        return super.selectPage(sql,returnType,curPage,pageSize,param);
    }
}
