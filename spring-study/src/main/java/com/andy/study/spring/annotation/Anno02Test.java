package com.andy.study.spring.annotation;

import com.andy.study.spring.annotation.config.Config01;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @time: 2020/11/27 十一月 09:11
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Anno02Test {


    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        new XmlBeanDefinitionReader(context).loadBeanDefinitions("bean01.xml");
        context.refresh();


//        GenericApplicationContext context2 = new GenericApplicationContext();
//        new GroovyBeanDefinitionReader(context).loadBeanDefinitions("services.groovy", "daos.groovy");
//        context.refresh();
    }

    @Test
    public  void test01(){
        GenericApplicationContext gac = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(gac);
        reader.loadBeanDefinitions("bean01.xml");
        gac.refresh();
        System.out.println(gac);
    }


    @Test
    public  void test02(){
        GenericApplicationContext gac = new GenericApplicationContext();
//        GroovyBeanDefinitionReader groovyBeanDefinitionReader = new GroovyBeanDefinitionReader(gac);
//        groovyBeanDefinitionReader.loadBeanDefinitions("services.groovy", "daos.groovy");
        gac.refresh();
        System.out.println(gac);
    }


    @Test
    public  void test03(){
        GenericApplicationContext gac = new GenericApplicationContext();

        AnnotatedBeanDefinitionReader  reader = new AnnotatedBeanDefinitionReader(gac);
        reader.register(Config01.class);

        gac.refresh();
        System.out.println(gac);

        gac.registerShutdownHook();
    }


    @Test
    public  void test04(){
        GenericApplicationContext gac = new GenericApplicationContext();

        ClassPathBeanDefinitionScanner  reader = new ClassPathBeanDefinitionScanner(gac);
        reader.scan("com.andy.study.spring.annotation.config");

        gac.refresh();
        System.out.println(gac);

        gac.registerShutdownHook();
    }

}
