//package com.liyi.study.base.day0419;
//
///**
// * @TODO: javastudy
// * @author: xiangdan/xiangdan@dtxytech.com
// * @time: 2021/4/19 16:32  星期一
// */
//public class SalariedEmployee extends Employee{
//
//    private double monthlySalary;//月工资
//
//    public double getMonthlySalary() {
//        return monthlySalary;
//    }
//
//    public void setMonthlySalary(double monthlySalary) {
//        this.monthlySalary = monthlySalary;
//    }
//
//    public SalariedEmployee(String name, int number, MyDate birthday) {
//        super(name, number, birthday);
//    }
//    public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary) {
//        super(name, number, birthday);
//        this.monthlySalary=monthlySalary;
//    }
//
//    @Override
//    public double earnings() {
//
//        return monthlySalary;
//
//    }
//
//    public String toString(){
//        return "SalariedEmployee["+super.toString()+"]";
//    }
//}
