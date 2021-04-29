package com.liyi.study.base.day0414.exer;

import java.util.Scanner;
import java.util.Vector;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 22:54  星期三
 */
public class ScoreTest {
    public static void main(String[] args) {

    //实例化Scanner，用于从键盘获取学生成绩
    Scanner scan=new Scanner(System.in);


    //创建Vector对象
    Vector v=new Vector();

    //给vector中添加数组

        int maxScore=0;
        char level;
        for (;;){
            System.out.println("请输入学生成绩（以负数输入代表结束）：");
            int score=scan.nextInt();

            if(score<0){
                break;
            }
            if (score>100){
                System.out.println("输入的数据非法，请重新输入!");
                continue;
            }
//            Integer inScore=new Integer(score);
//            v.addElement(inScore);
            v.add(score);

            //获取成绩的最大值
            if (maxScore<score){
                maxScore=score;
            }

        }

        //遍历vector,得到每个学生的成绩，并与最大值比较，得到每个学生的等级
        for (int i=0;i<v.size();i++){
            Object obj=v.elementAt(i);
//            Integer InScore=(Integer) obj;
//            int score=InScore.intValue();
            int score=(int) obj;
            if (maxScore-score<=10){
                level='A';
            }else if (maxScore-score<=20){
                level='B';
            }else if (maxScore-score<=30){
                level='C';
            }else {
                level='D';
            }
            System.out.println("student-"+i+"score is"+score+",level is"+level);
        }


}
}
