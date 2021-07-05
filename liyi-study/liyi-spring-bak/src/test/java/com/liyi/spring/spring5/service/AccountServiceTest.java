package com.liyi.spring.spring5.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 22:44  星期日
 */
class AccountServiceTest {

    @Test
    void accountMoney() {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }
}