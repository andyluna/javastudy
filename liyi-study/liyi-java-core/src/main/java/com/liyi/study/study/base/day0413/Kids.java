package com.liyi.study.study.base.day0413;

import com.liyi.study.base.day0413.ManKind;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/13 14:36  星期二
 */
public class Kids extends ManKind {
    private int yearsOld;

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println("I am"+yearsOld+"years old.");
    }


    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
