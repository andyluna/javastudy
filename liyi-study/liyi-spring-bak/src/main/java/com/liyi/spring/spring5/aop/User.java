package com.liyi.spring.spring5.aop;

import org.springframework.stereotype.Component;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 10:43  星期四
 */
//被增强类
@Component
public class User {

    public void add(){
        System.out.println("add.....");
    }

}
