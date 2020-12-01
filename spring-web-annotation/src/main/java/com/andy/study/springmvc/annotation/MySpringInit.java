package com.andy.study.springmvc.annotation;

import com.andy.study.springmvc.config.SpringMvc;
import com.andy.study.springmvc.config.SpringRoot;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @time: 2020/12/1 十二月 14:39
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MySpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRoot.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvc.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8")
        };
    }
}
