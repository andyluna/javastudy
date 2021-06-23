package com.study.cms.comm.dao;

import com.study.cms.comm.vo.PageRes;

import java.util.List;

/**
 * 增强 CommonDao
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/23 23:32  星期三
 */

public interface CommonDaoEnhance extends CommonDao {


    int update(Object o);

    int insert(Object o);

    <T> int deleteById(Class<T> clz,Object id);

    int delete(Object o);

    <T> List<T> selectList(Object o);

    <T> T selectOne(Object o);

    <T> PageRes  selectPage(Object o ,Integer curPage,Integer pageSize);

}
