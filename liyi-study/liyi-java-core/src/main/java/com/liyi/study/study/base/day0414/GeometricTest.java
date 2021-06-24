package com.liyi.study.study.base.day0414;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 17:37  星期三
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test=new GeometricTest();

        Circle c1=new Circle(2.3,"white",1.0);
        test.displayGeomtricObject(c1);

        Circle c2=new Circle(3.3,"white",1.0);
        test.displayGeomtricObject(c2);

        boolean isEquals=test.equalsArea(c1,c2);
        System.out.println("c1和c2的面积是否相等："+isEquals);

        MyRectangle rect=new MyRectangle(2.1,3.4,"read",2.0);
        test.displayGeomtricObject(rect);

    }


    //判断两个对象的面积是否相等
    public boolean equalsArea(GeomtricObject o1, GeomtricObject o2){
        return o1.findArea()==o2.findArea();
    }


    public void displayGeomtricObject(GeomtricObject o){
        System.out.println("面积是"+o.findArea());
    }
}
