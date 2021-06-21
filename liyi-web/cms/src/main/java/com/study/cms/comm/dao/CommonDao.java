package com.study.cms.comm.dao;

import com.study.cms.comm.vo.PageRes;

import java.util.List;

/**
 * 公共的DAO
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 23:53  星期一
 */
public interface CommonDao {


    /**
     * 1.修改或删除新增的方法
     * @param sql   要执行的sql语句
     * @param param 参数
     * @return 影响条数
     */
    int update(String sql,Object ... param);

    /**
     * 2.分页查询的sql语句
     * @param sql         要执行的sql语句
     * @param returnType  返回的java类型
     * @param curPage     当前页
     * @param pageSize    每页显示多少条
     * @param param       参数
     * @return  分页对象
     */
    <T> PageRes  selectPage(String sql,Class<T> returnType,Integer curPage,Integer pageSize,Object ... param);

    /**
     * 查询列表
     * @param sql
     * @param returnType
     * @param param
     * @param <T>
     * @return
     */
    <T> List<T> selectList(String sql, Class<T> returnType, Object ... param);

    /**
     * 查询一个
     * @param sql
     * @param returnType
     * @param param
     * @param <T>
     * @return
     */
    <T> T selectOne(String sql, Class<T> returnType, Object ... param);



}
