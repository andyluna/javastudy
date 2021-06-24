package com.liyi.study.study.base.day0414;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 17:24  星期三
 */
public class GeomtricObject {
    protected String color;

    protected double weight;

    public GeomtricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //面积
    public double findArea(){

        return 0.0;
    }
}
