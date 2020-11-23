package com.andy.study.spring.xml.beanpostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @time: 2020/11/23 十一月 16:47
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor,
        BeanFactoryAware, ApplicationContextAware, EnvironmentAware , InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("之前:{},{}",beanName,bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug("之后:{},{}",beanName,bean);
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.debug("设置beanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("设置applicationContext");

    }

    @Override
    public void setEnvironment(Environment environment) {
        log.debug("设置environment");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("这里启动了哦");
    }
}
