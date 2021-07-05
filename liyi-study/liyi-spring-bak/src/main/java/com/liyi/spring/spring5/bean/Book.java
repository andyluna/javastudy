package com.liyi.spring.spring5.bean;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 17:52  星期四
 */
public class Book {
//    private List<String> list;
//
//    public void setList(List<String> list) {
//        this.list = list;
//    }
//
//
//    public void test(){
//        System.out.println(list);
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "list=" + list +
//                '}';
//    }

    private int id;
    private String name;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
