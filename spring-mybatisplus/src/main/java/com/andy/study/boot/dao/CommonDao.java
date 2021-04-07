package com.andy.study.boot.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

/**
 * TODO 公共DAO
 * @time: 2021/1/20 一月 15:26
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface CommonDao {

    /**---------------------查询方法汇总-----------------------------------------------**/
    /**
     * TODO 根据SQL语句查询一条数据 返回map
     * @param sql  传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param param 具体的参数
     * @return 返回Map对象
     */
    Map<String,Object> selectOne(String sql, Object ...param);
    /**
     * TODO 根据SQL语句查询一条数据 返回map
     * @param sql  传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param param 具体的参数
     * @return 返回Map对象
     */
    Map<String,Object> selectOne(String sql, Map<String,Object> param);

    /**
     * TODO 根据SQL语句查询一条数据 返回javabean
     * @param sql 传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param resultType 具体的参数
     * @param param 具体的参数
     * @return 具体javabean
     */
    <T> T selectOne(String sql,Class<T> resultType, Object ...param);
    /**
     * TODO 根据SQL语句查询一条数据 返回javabean
     * @param sql 传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param resultType 具体的参数
     * @param param 具体的参数
     * @return 具体javabean
     */
    <T> T selectOne(String sql,Class<T> resultType, Map<String,Object> param);



    /**
     * TODO 根据SQL语句查询列表数据 返回List<map>
     * @param sql  传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param param 具体的参数
     * @return 返回Map对象
     */
    List<Map<String,Object>> selectList(String sql, Object ...param);
    /**
     * TODO 根据SQL语句查询列表数据 返回List<map>
     * @param sql  传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param param 具体的参数
     * @return 返回Map对象
     */
    List<Map<String,Object>> selectList(String sql, Map<String,Object> param);


    /**
     * TODO 根据SQL语句查询列表数据 返回List<javabean></javabean>
     * @param sql 传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param resultType 具体的参数
     * @param param 具体的参数
     * @return 具体javabean
     */
    <T> List<T> selectList(String sql, Class<T> resultType, Object ...param);
    /**
     * TODO 根据SQL语句查询列表数据 返回List<javabean></javabean>
     * @param sql 传入的SQL语句参数带问号  例如:select id,name from user where id=?
     * @param resultType 具体的参数
     * @param param 具体的参数
     * @return 具体javabean
     */
    <T> List<T> selectList(String sql, Class<T> resultType, Map<String,Object> param);


    /**---------------------分页查询方法汇总--------------------------------------------**/

//    /**
//     * 根据 entity 条件，查询全部记录（并翻页）
//     *
//     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
//     * @param queryWrapper 实体对象封装操作类（可以为 null）
//     */
//    <T> IPage<T> selectPage();
//
//    /**
//     * 根据 Wrapper 条件，查询全部记录（并翻页）
//     *
//     * @param page         分页查询条件
//     * @param queryWrapper 实体对象封装操作类
//     */
//    <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

    /**---------------------新增,修改,删除方法汇总---------------------------------------**/
    int update(String sql,Object ... param);
    int update(String sql,Map<String,Object> param);
    int update(String sql, SqlParameterSource paramSource);


    /**---------------------调用存储过程方法--------------------------------------------**/

    void execute(String sql) throws DataAccessException;
    <T> T execute(String sql, PreparedStatementCallback<T> action) throws DataAccessException;
    <T> T execute(ConnectionCallback<T> action) throws DataAccessException;
    <T> T execute(StatementCallback<T> action) throws DataAccessException;
    <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action) throws DataAccessException;
    <T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action) throws DataAccessException;



}
