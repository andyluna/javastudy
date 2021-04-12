package com.liyi.study.study001.day0412;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/12 15:59  星期一
 */
public class PassObjiect {

    public static void main(String[] args) {
        PassObjiect test=new PassObjiect();
        Circle c=new Circle();
        test.printAreas(c,5);
    }

    public void printAreas(Circle c,int time){
        System.out.println("Radius\t\tArea");

        for (int i=1;i<=time;i++){
            //设置圆的半径
            c.radius=i;
            System.out.println(c.radius+"\t\t"+c.findArea());
        }
    }
}
