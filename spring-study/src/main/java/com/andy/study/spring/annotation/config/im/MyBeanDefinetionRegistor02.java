package com.andy.study.spring.annotation.config.im;

import com.andy.study.spring.annotation.config.bean.Jerry03;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @time: 2020/11/30 十一月 15:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyBeanDefinetionRegistor02 implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        RootBeanDefinition definition = new RootBeanDefinition(Jerry03.class);
        String beanName = importBeanNameGenerator.generateBeanName(definition, registry);
        registry.registerBeanDefinition(beanName, definition);
    }
}
