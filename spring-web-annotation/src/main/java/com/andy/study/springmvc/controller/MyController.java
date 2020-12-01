package com.andy.study.springmvc.controller;

import com.andy.study.springmvc.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @time: 2020/12/1 十二月 16:19
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Controller
@Slf4j
public class MyController implements InitializingBean {


    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello(String name){
        return "你好"+name;
    }

    @ResponseBody
    @GetMapping("/getPerson")
    public Person getPerson(String name){
        Person p = new Person(1, "向丹", new Date(), LocalDate.now(), LocalDateTime.MAX.now());
        log.debug("person = {}",p);
        return p;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("MyController初始化成功了");
    }
}
