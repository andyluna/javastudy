package com.liyi.study.study.base.day0414;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 17:31  星期三
 */
public class MyRectangle extends GeomtricObject {

    private double width;
    private double height;

    public MyRectangle(double width,double height,String color, double weight) {
        super(color, weight);
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea(){
        return width*height;
    }
}
