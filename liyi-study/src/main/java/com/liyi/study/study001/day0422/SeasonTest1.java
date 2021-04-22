package com.liyi.study.study001.day0422;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 22:05  星期四
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 s1=Season1.SPRING;
        System.out.println(s1);

        //values
        Season1[] values = Season1.values();
        for (int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }
        //valuesOf（String objName）:返回枚举类中对象名是objName的对象
        Season1 s2=Season1.valueOf("SUMMER");//区分大小写 不匹配则抛异常IllegalArgumentException
        System.out.println(s2);

        s1.show();

    }
}

interface Info{
    void show();
}

//enum关键字定义枚举类
enum Season1 implements Info{
    //提供当前枚举类的多个对象,多个对象用","隔开，末尾对象用";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {

            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冬雪皑皑"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
    //声明Season对象的属性：private final修饰

    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器,并给对象赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }


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
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }


//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
