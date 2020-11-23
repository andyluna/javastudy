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
 * @time: 2020/11/23 22:49  星期一
 */
@Slf4j
public class MyBeanFactory001PostProcessor implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.debug("我的第1个 beanfactory后置处理器  注册bean:{}",registry);
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(MyBeanFactory002PostProcessor.class.getName());
        registry.registerBeanDefinition("myBeanFactory002PostProcessor",beanDefinition);
        log.debug("第1个 里面注册第2个注册成功");

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("MyBeanFactory001PostProcessor:{}",beanFactory);

    }
}
