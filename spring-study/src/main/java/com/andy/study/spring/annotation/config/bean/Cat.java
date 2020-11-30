package com.andy.study.spring.annotation.config.bean;

/**
 * @time: 2020/11/30 十一月 10:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Cat {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
