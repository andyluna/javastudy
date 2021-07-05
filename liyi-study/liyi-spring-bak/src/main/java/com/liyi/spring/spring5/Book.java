package com.liyi.spring.spring5;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用set方法进行注入属性
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 15:59  星期四
 */
public class Book implements InitializingBean , DisposableBean {
    private String bname;
    private String bauthor;
    private String address;
    private Author author;


    public void init1(){
        System.out.println("init1执行了");
    }


    @PostConstruct
    public void init2(){
        System.out.println("init2执行了");
    }


    public void destory1(){
        System.out.println("destory1执行了");
    }
    @PreDestroy
    public void destory2(){
        System.out.println("destory2执行了");
    }
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo(){
        System.out.println(bname+": :"+bauthor+": :"+address);
    }

    public String getBname() {
        return bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public String getAddress() {
        return address;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", address='" + address + '\'' +
                ", author=" + author +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy  ---执行了");
    }
}
