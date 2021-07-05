package com.liyi.spring.spring5.javaanno.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 19:10  星期一
 */
@Configuration                                               //配置类
@ComponentScan(basePackages = "com.liyi.spring.spring5")     //开启组件扫描
@EnableTransactionManagement                                 //开启事务
public class AccountConfig {

    //创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/cms?serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("liyi");
        druidDataSource.setPassword("liyi");

        return druidDataSource;
    }


    //创建JdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        //在ioc容器中根据类型找到dataSource
        JdbcTemplate jdbcTemplate=new JdbcTemplate();

        //注入dataSource
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    //创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
        //注入dataSource
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }
}
