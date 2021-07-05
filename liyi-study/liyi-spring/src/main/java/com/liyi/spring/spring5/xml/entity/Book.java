package com.liyi.spring.spring5.xml.entity;/**
 *@TODO: javastudy
 *@author: xiangdan/xiangdan@dtxytech.com
 *@time: 2021/7/5 0:25  星期一
 */
public class Book {
    private Integer id;
    private String name;
    private Double price;

    public Book() {
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
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
