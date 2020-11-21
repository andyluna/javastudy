package com.andy.study.spring.circular;

/**
 * @time: 2020/11/20 十一月 21:11
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class B1 {

    private A1 a1;

    public B1() {
    }

    public B1(A1 a1) {
        this.a1 = a1;
    }

    public void setA1(A1 a1) {
        this.a1 = a1;
    }
}
