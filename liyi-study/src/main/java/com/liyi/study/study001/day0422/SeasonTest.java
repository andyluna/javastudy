package com.liyi.study.study001.day0422;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 21:34  星期四
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring=Season.SPRING;
        System.out.println(spring);
    }

}

//自定义枚举类
class Season{
    //声明Season对象的属性：private final修饰

    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器,并给对象赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    //提供当前枚举类的多个对象:public static final修饰
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","夏日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","冬雪皑皑");

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //toString

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


