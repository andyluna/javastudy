package com.liyi.study.study.base.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 18:43  星期四
 */
public class StudentTest {
    public static void main(String[] args) {

        //声明student类型的数组
        Student[] stus=new Student[20];

        for (int i=0;i<stus.length;i++){
            //给数组元素赋值
            stus[i]=new Student();
            //给Student的属性赋值
            stus[i].number=(i+1);
            //年级1-6
            stus[i].state=(int)(Math.random()*(6-1+1)+1);
            //成绩 0-100
            stus[i].score=(int)(Math.random()*(100-0+1));





        }



        //打印出3年级的学生信息
        test2(stus,3);





        //使用冒泡排序将学生成绩排序，并遍历所有学生信息
        test3(stus);

        test1(stus);



    }

    //遍历数组的方法
    public  static void test1(Student[] stus){
        for (int i=0;i<stus.length;i++){
            //System.out.println(stus[i].number+","+stus[i].state+","+stus[i].score);

            System.out.println(stus[i].info());
        }
    }


    //查找Student数组中指定年级的信息
    public static void test2(Student[] stus,int state){
        for (int i=0;i<stus.length;i++){
            if (stus[i].state==state){
                System.out.println(stus[i].info());
            }
        }
    }


    //冒泡排序的方法
    public static void test3(Student[] stus){
        for (int i=0;i<stus.length-1;i++){
            for (int j=0;j<stus.length-1-i;j++){
                if (stus[j].score>stus[j+1].score){
                    Student stu=stus[j];
                    stus[j]=stus[j+1];
                    stus[j+1]=stu;
                }
            }
        }
    }






}
