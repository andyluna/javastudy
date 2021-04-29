package com.liyi.study.base.day0413;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 14:46  星期二
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids someKid=new Kids(12);
        someKid.printAge();
        someKid.setSalary(0);
        someKid.setSex(1);

        someKid.employeed();
        someKid.manOrWoman();
    }
}
