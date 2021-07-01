package com.liyi.spring.spring5.factorybean;

import com.liyi.spring.spring5.bean.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 19:08  星期四
 */
public class MyBean implements FactoryBean<Course> {


    //定义返回Bean
    @Override
    public Course getObject() throws Exception {
        Course course=new Course();
        course.setCname("工厂Bean测试");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
