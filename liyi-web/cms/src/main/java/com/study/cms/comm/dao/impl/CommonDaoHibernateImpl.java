package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDao;
import com.study.cms.comm.utils.SqlAndParam;
import com.study.cms.comm.vo.PageRes;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 0:01  星期二
 */
public class CommonDaoHibernateImpl implements CommonDao {
    @Override
    public int update(String sql, Object... param) {
        return 0;
    }

    @Override
    public int updateBySqlAndParam(SqlAndParam sqlAndParam) {
        return 0;
    }

    @Override
    public <T> PageRes selectPage(String sql, Class<T> returnType, Integer curPage, Integer pageSize, Object... param) {
        return null;
    }

    @Override
    public <T> List<T> selectList(String sql, Class<T> returnType, Object... param) {
        return null;
    }

    @Override
    public <T> T selectOne(String sql, Class<T> returnType, Object... param) {
        return null;
    }
}
