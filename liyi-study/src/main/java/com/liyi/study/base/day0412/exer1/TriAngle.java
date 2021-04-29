package com.liyi.study.base.day0412.exer1;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 18:51  星期一
 */
public class TriAngle {

    private double base;//底边长
    private double height;//高

    public TriAngle(){

    }
    public TriAngle(double b,double h){
        base=b;
        height=h;
    }

    public void setBase(double b){
        base=b;
    }
    public double getBase(){
        return base;
    }
    public void setHeight(double h){
        height=h;
    }
    public double getHeight(){
        return height;
    }

}
