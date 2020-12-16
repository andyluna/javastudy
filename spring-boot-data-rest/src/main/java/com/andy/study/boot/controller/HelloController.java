package com.andy.study.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2020/11/29 十一月 15:09
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "你好";
    }

}
