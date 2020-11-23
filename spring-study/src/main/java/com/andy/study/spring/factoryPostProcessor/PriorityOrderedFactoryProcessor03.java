package com.andy.study.spring.factoryPostProcessor;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;

/**
 * @time: 2020/11/23 十一月 17:39
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class PriorityOrderedFactoryProcessor03 implements BeanFactoryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.debug("优先级PriorityOrderedFactoryProcessor03");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
