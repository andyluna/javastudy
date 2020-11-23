package com.andy.study.spring.xml.circular;

/**
 * @time: 2020/11/20 十一月 21:10
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class A1 {

    private B1 b1;

    public A1() {
    }

    public A1(B1 b1) {
        this.b1 = b1;
    }

    public void setB1(B1 b1) {
        this.b1 = b1;
    }
}
