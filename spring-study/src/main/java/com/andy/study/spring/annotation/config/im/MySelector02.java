package com.andy.study.spring.annotation.config.im;

import com.andy.study.spring.annotation.config.bean.Dog;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @time: 2020/11/30 十一月 15:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MySelector02 implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Dog.class.getName()};
    }
}
