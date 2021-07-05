package com.liyi.spring.spring5.xmlanno.test;

import com.liyi.spring.spring5.xmlanno.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 16:30  星期一
 */
public class XmlAnnoTest {

    @Test
    public void accountTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("xmlanno/bean-xmlanno01.xml");
        AccountService accountService=context.getBean("accountService",AccountService.class);

        accountService.accountMoney();

    }

    @Test
    public void accountTest2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("xmlanno/bean-xmlanno02.xml");
        AccountService accountService=context.getBean("accountService",AccountService.class);

        accountService.accountMoney();

    }
}
