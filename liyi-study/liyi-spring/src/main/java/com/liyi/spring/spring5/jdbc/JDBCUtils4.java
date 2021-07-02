package com.liyi.spring.spring5.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/2 15:19  星期五
 */
public class JDBCUtils4 implements InitializingBean {

    //引入数据源 druid
    private DruidDataSource dataSource;

    //属性初始化完成之后  会自动执行这个方法
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
