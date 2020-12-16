package com.andy.study.spring.xml.factoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.PriorityOrdered;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/11/23 23:05  星期一
 */
@Slf4j
public class MyBeanFactory002PostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.debug("我的第2个 beanfactory后置处理器  开始注册:{}", registry);
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(MyBeanFactory003PostProcessor.class.getName());
        registry.registerBeanDefinition("MyBeanFactory003PostProcessor", beanDefinition);
        log.debug("第2个 里面注册第3个注册成功");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("MyBeanFactory002PostProcessor ");

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
