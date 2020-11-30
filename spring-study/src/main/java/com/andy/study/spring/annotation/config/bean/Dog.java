package com.andy.study.spring.annotation.config.bean;

/**
 * @time: 2020/11/30 十一月 10:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Dog {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
