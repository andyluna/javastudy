package com.andy.study.springmvc.controller;

import com.andy.study.springmvc.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @time: 2020/12/3 十二月 09:07
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@RequestMapping(value = "/mycontroller01")
@Controller
@Slf4j
public class MyController01 {

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name) {
        log.debug("sayHello:{}", name);
        return "你好hello" + name;
    }

    @GetMapping("/sayHello1")
    @ResponseBody
    public String sayHello1(String name) {
        log.debug("sayHello1:{}", name);
        return "你好hello1" + name;

    }


    @GetMapping("/getStundet")
    @ResponseBody
    public Student getStudent() {
        Student student = new Student();
        student.setId(2);
        student.setName("张3");

        return student;
    }


}
