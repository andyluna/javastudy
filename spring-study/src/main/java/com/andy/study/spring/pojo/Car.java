package com.andy.study.spring.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.beans.ConstructorProperties;

/**
 * @time: 2020/11/20 十一月 14:37
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Car implements InitializingBean , DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(Car.class);
    private Integer id;

    private String name;

    private Double price;

    public Car(){
        log.debug("car 构造函数");
    }
    @ConstructorProperties({"id","name","price"})
    public Car(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public void xmlinit()  {
        log.debug("xmlinit");
    }
    @PostConstruct
    public void postConstruct()  {
        log.debug("PostConstruct");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
    }

    public void xmldestory(){
        log.debug("xmldestory");
    }

    @PreDestroy
    public void preDestroy()  {
        log.debug("PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("DisposableBean");
    }
}
