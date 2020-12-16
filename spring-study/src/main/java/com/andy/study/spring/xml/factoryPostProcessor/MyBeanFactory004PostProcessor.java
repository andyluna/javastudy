package com.andy.study.spring.xml.factoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/11/23 23:05  星期一
 */
@Slf4j
public class MyBeanFactory004PostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.debug("我的第4个 beanfactory后置处理器  开始注册:{}", registry);
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(MyBeanFactory005PostProcessor.class.getName());
        registry.registerBeanDefinition("myBeanFactory005PostProcessor", beanDefinition);
        log.debug("第4个注册成功");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("MyBeanFactory004PostProcessor ");

    }


}
