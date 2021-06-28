package com.study.cms.comm.dao.impl;

import com.study.cms.comm.dao.CommonDaoEnhance;
import com.study.cms.comm.vo.PageRes;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/28 22:45  星期一
 */
public class CommonDaoMybatisImpl extends CommonDaoJdbcImpl implements CommonDaoEnhance {

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public <T> int deleteById(Class<T> clz, Object id) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public <T> List<T> selectList(Object o) {
        return null;
    }

    @Override
    public <T> T selectOne(Object o) {
        return null;
    }

    @Override
    public <T> PageRes selectPage(Object o, Integer curPage, Integer pageSize) {
        return null;
    }
}
