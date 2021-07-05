package com.liyi.spring.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 21:51  星期四
 */
@Configuration  //作为配置类,替代配置文件
@ComponentScan(basePackages = ("com.liyi.spring.spring5"))  //开启注解扫描并确定扫描的路径
@EnableAspectJAutoProxy(proxyTargetClass = true)            //开启Aspect生成代理对象
public class SpringConfig {

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

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }


    //创建事务管理器





}
