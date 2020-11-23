package com.andy.study.spring.xml.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @time: 2020/11/23 十一月 08:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyClasspathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClasspathXmlApplicationContext() {
    }

    public MyClasspathXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public MyClasspathXmlApplicationContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    public MyClasspathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    public MyClasspathXmlApplicationContext(String[] configLocations, ApplicationContext parent) throws BeansException {
        super(configLocations, parent);
    }

    public MyClasspathXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
        super(configLocations, refresh);
    }

    public MyClasspathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent) throws BeansException {
        super(configLocations, refresh, parent);
    }

    public MyClasspathXmlApplicationContext(String path, Class<?> clazz) throws BeansException {
        super(path, clazz);
    }

    public MyClasspathXmlApplicationContext(String[] paths, Class<?> clazz) throws BeansException {
        super(paths, clazz);
    }

    public MyClasspathXmlApplicationContext(String[] paths, Class<?> clazz, ApplicationContext parent) throws BeansException {
        super(paths, clazz, parent);
    }

    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowBeanDefinitionOverriding(true);
        super.setAllowCircularReferences(true);
        super.customizeBeanFactory(beanFactory);
    }




    }
