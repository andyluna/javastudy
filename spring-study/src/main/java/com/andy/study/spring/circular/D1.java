package com.andy.study.spring.circular;

/**
 * @time: 2020/11/20 十一月 22:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class D1 {

    private F1 f1 = new F1();

    public F1 getF1() {
        return f1;
    }

    public void setF1(F1 f1) {
        this.f1 = f1;
    }
}
