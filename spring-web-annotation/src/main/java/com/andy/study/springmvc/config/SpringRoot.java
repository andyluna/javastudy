package com.andy.study.springmvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2020/12/1 十二月 14:41
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@Configuration
@ComponentScan( value = "com.andy.study.springmvc",
        useDefaultFilters = true,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = ControllerAdvice.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = RestController.class),
        })
public class SpringRoot {
    public SpringRoot(){
        log.debug("Root容器初始化了");
    }
}
