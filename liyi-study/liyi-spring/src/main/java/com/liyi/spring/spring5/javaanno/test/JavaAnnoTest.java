package com.liyi.spring.spring5.javaanno.test;

import com.liyi.spring.spring5.javaanno.config.AccountConfig;
import com.liyi.spring.spring5.xmlanno.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 19:22  星期一
 */
public class JavaAnnoTest {

    @Test
    public void accountTest(){
        ApplicationContext context= new AnnotationConfigApplicationContext(AccountConfig.class);
        AccountService accountService= (AccountService) context.getBean("accountService");

        accountService.accountMoney();

    }
}
