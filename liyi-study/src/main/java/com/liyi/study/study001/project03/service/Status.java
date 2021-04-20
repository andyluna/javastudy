package com.liyi.study.study001.project03.service;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 10:29  星期二
 */
public class Status {

    private final String NAME;

    private Status(String name){

        this.NAME=name;
    }

    public static final Status FREE=new Status("FREE");

    public static final Status BUSY=new Status("BUSY");

    public static final Status VOCATION=new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
