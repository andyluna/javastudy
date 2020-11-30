package com.andy.study.spring.annotation.config.im;

import com.andy.study.spring.annotation.config.bean.Jerry;
import com.andy.study.spring.annotation.config.bean.Jerry01;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @time: 2020/11/30 十一月 15:56
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyDeferredSelector02 implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                Jerry01.class.getName()
        };
    }
}
