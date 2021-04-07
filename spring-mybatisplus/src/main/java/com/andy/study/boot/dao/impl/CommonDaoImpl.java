package com.andy.study.boot.dao.impl;

import com.andy.study.boot.dao.CommonDao;
import com.andy.study.boot.mapper.CommonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @time: 2021/1/20 一月 15:26
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Repository
public class CommonDaoImpl implements CommonDao {
    private static final Logger log = LoggerFactory.getLogger(CommonDaoImpl.class);
    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Map<String, Object> selectOne(String sql, Object... param) {
        List<Map<String, Object>> results = jdbcTemplate.query(sql, param, new RowMapperResultSetExtractor<>(new ColumnMapRowMapper(), 1));
        if (CollectionUtils.isEmpty(results)) {
            log.warn("根据SQL[{}],参数{} 没有查询到数据",sql,param);
            return null;
        }
        if (results.size() > 1) {
            log.warn("根据SQL[{}],参数{} 查询出来有多条数据",sql,param);
            throw new IncorrectResultSizeDataAccessException(1, results.size());
        }
        return results.iterator().next();
    }

    @Override
    public Map<String, Object> selectOne(String sql, Map<String, Object> param) {
        List<Map<String, Object>> results = namedParameterJdbcTemplate.query(sql, param, new RowMapperResultSetExtractor<>(new ColumnMapRowMapper()));
        if (CollectionUtils.isEmpty(results)) {
            log.warn("根据SQL[{}],参数{} 没有查询到数据",sql,param);
            return null;
        }
        if (results.size() > 1) {
            log.warn("根据SQL[{}],参数{} 查询出来有多条数据",sql,param);
            throw new IncorrectResultSizeDataAccessException(1, results.size());
        }
        return results.iterator().next();
    }

    @Override
    public <T> T selectOne(String sql, Class<T> resultType, Object... param) {
        List<T> res =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(resultType),param);
        if (CollectionUtils.isEmpty(res)) {
            log.warn("根据SQL[{}],参数{} 没有查询到数据",sql,param);
            return null;
        }
        if (res.size() > 1) {
            log.warn("根据SQL[{}],参数{} 查询出来有多条数据",sql,param);
            throw new IncorrectResultSizeDataAccessException(1, res.size());
        }
        return res.iterator().next();
    }

    @Override
    public <T> T selectOne(String sql, Class<T> resultType, Map<String, Object> param) {
        List<T> res = namedParameterJdbcTemplate.query(sql, param, new BeanPropertyRowMapper<T>(resultType));
        if (CollectionUtils.isEmpty(res)) {
            log.warn("根据SQL[{}],参数{} 没有查询到数据",sql,param);
            return null;
        }
        if (res.size() > 1) {
            log.warn("根据SQL[{}],参数{} 查询出来有多条数据",sql,param);
            throw new IncorrectResultSizeDataAccessException(1, res.size());
        }
        return res.iterator().next();
    }

    @Override
    public List<Map<String, Object>> selectList(String sql, Object... param) {
        List<Map<String, Object>> list = jdbcTemplate.query(sql, param, new RowMapperResultSetExtractor<>(new ColumnMapRowMapper()));
        return list;
    }

    @Override
    public List<Map<String, Object>> selectList(String sql, Map<String, Object> param) {
        List<Map<String, Object>> list = namedParameterJdbcTemplate.query(sql, param, new RowMapperResultSetExtractor<>(new ColumnMapRowMapper()));
        return list;
    }

    @Override
    public <T> List<T> selectList(String sql, Class<T> resultType, Object... param) {
        List<T> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(resultType),param);
        return list;
    }

    @Override
    public <T> List<T> selectList(String sql, Class<T> resultType, Map<String, Object> param) {
        List<T> list = namedParameterJdbcTemplate.query(sql, param, new BeanPropertyRowMapper<T>(resultType));
        return list;
    }

    @Override
    public int update(String sql, Object... param) {

        int update = jdbcTemplate.update(sql, param);
        return update;
    }

    @Override
    public int update(String sql, Map<String, Object> param) {
        int update = namedParameterJdbcTemplate.update(sql, param);
        return update;
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource) {
        int update = namedParameterJdbcTemplate.update(sql, paramSource);
        return update;
    }

    @Override
    public void execute(String sql) throws DataAccessException {
        jdbcTemplate.execute(sql);
    }

    @Override
    public <T> T execute(String sql, PreparedStatementCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(sql,action);
    }

    @Override
    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(action);
    }

    @Override
    public <T> T execute(StatementCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(action);
    }

    @Override
    public <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(psc,action);
    }

    @Override
    public <T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(csc,action);
    }
}
