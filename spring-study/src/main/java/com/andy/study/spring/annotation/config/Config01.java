package com.andy.study.spring.annotation.config;

import com.andy.study.spring.annotation.config.bean.Cat;
import com.andy.study.spring.annotation.config.bean.Dog;
import com.andy.study.spring.annotation.config.im.MyBeanDefinetionRegistor01;
import com.andy.study.spring.annotation.config.im.MyBeanDefinetionRegistor02;
import com.andy.study.spring.annotation.config.im.MyDeferredSelector01;
import com.andy.study.spring.annotation.config.im.MyDeferredSelector02;
import com.andy.study.spring.annotation.config.im.MyImportService;
import com.andy.study.spring.annotation.config.im.MyImportService01;
import com.andy.study.spring.annotation.config.im.MyImportService02;
import com.andy.study.spring.annotation.config.im.MyImportService03;
import com.andy.study.spring.annotation.config.im.MySelector01;
import com.andy.study.spring.annotation.config.im.MySelector02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/11/24 0:08  星期二
 */

@Import({MyImportService.class, MyImportService01.class, MyImportService02.class, MyImportService03.class,
        MySelector01.class, MySelector02.class,
        MyDeferredSelector01.class, MyDeferredSelector02.class,
        MyBeanDefinetionRegistor01.class, MyBeanDefinetionRegistor02.class
})
public class Config01 {

    @Bean
    private Dog dog(){
        return new Dog();
    }


    @Bean(name ="mycat")
    @Description("my firstCat")
    public Cat cat(){
        return new Cat();
    }
}
