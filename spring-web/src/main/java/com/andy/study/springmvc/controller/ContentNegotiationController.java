package com.andy.study.springmvc.controller;

import com.andy.study.springmvc.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @time: 2020/12/3 十二月 20:32
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Controller
@RequestMapping("/content")
@Slf4j
public class ContentNegotiationController {

    @GetMapping("/getStudent*")
    @ResponseBody
    public Student getStudent(){
        Student student = new Student();
        student.setId(2);
        student.setName("李四");
        return student;
    }


    @GetMapping(value = "/getStudentJson",produces ={"application/json"} )
    @ResponseBody
    public Student getStudentJson(){
        Student student = new Student();
        student.setId(2);
        student.setName("李四");
        return student;
    }


    @GetMapping(value = "/getStudentXml",produces ={"application/xml"})
    @ResponseBody
    public Student getStudentXml(){
        Student student = new Student();
        student.setId(2);
        student.setName("李四");
        return student;
    }

}
