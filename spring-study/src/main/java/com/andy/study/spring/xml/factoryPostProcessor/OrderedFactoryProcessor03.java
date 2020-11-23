package com.andy.study.spring.xml.factoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @time: 2020/11/23 十一月 17:42
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class OrderedFactoryProcessor03 implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("OrderedFactoryProcessor03");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
