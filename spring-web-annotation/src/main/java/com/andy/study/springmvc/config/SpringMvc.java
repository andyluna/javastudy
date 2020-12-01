package com.andy.study.springmvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @time: 2020/12/1 十二月 14:41
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@Configuration
@ComponentScan( value = "com.andy.study.springmvc.controller",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = RestController.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = ControllerAdvice.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = RestController.class)
})
@EnableWebMvc
public class SpringMvc  implements WebMvcConfigurer, InitializingBean {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        log.debug("configurer = "+configurer);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("Mvc容器初始化了");

    }
}
