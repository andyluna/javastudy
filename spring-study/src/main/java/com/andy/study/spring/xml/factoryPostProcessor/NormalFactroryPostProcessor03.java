package com.andy.study.spring.xml.factoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.LoadTimeWeaver;

/**
 * @time: 2020/11/23 十一月 16:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class NormalFactroryPostProcessor03 implements BeanFactoryPostProcessor,
        BeanFactoryAware, ApplicationContextAware, EnvironmentAware, InitializingBean,
        BeanNameAware, LoadTimeWeaverAware, MessageSourceAware, ApplicationEventPublisherAware {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("NormalFactroryPostProcessor01 执行了:{}", beanFactory);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.debug("设置NormalFactroryPostProcessor03 --- beanFactory");
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

    @Override
    public void setBeanName(String name) {
        log.debug("name = {}", name);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.debug("applicationEventPublisher = {}", applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.debug("messageSource = {}", messageSource);

    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        log.debug("loadTimeWeaver = {}", loadTimeWeaver);

    }
}
