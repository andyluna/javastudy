package com.liyi.study.base.day0414;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 17:27  星期三
 */
public class Circle extends GeomtricObject{

    private double radius;

    public Circle(double radius,String color,double weight){
        super(color,weight);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return 3.14*radius*radius;
    }
}
