//package com.liyi.study.base.day0419;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/4/19 16:38  星期一
// */
//public class HourlyEmployee extends Employee{
//
//    private int wage;//每小时的工资
//    private int hour;//月工作的小时数
//
//    public HourlyEmployee(String name, int number, MyDate birthday) {
//        super(name, number, birthday);
//    }
//
//    public HourlyEmployee(String name, int number, MyDate birthday,int wage,int hour) {
//        super(name, number, birthday);
//        this.wage=wage;
//        this.hour=hour;
//    }
//
//    @Override
//    public double earnings() {
//        return wage*hour;
//    }
//
//    public String toString(){
//        return "HourlyEmployee["+super.toString()+"]";
//    }
//}
