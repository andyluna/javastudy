package com.liyi.spring.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 21:51  星期四
 */
@Configuration  //作为配置类,替代配置文件
@ComponentScan(basePackages = ("com.liyi.spring.spring5"))  //开启注解扫描并确定扫描的路径
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
