package com.liyi.spring.spring5.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/2 15:19  星期五
 */
public class JDBCUtils3 implements InitializingBean {

    //引入数据源 druid
    private DruidDataSource dataSource;

    private String driver;

    private String url;

    private String username;

    private String password;
    //属性初始化完成之后  会自动执行这个方法
    @Override
    public void afterPropertiesSet() throws Exception {
        dataSource = new DruidDataSource();

        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.init();
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }





    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
