package com.andy.study.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 *
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述:
 *
 * 输出到长度为8的新字符串数组
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test004 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sr.hasNext()) {
            list.add(sr.nextLine());
        }

        for(String str:list){
            String s = str;
            while( s.length()>=8){
                String pre = s.substring(0,8);
                System.out.println(pre);
                s = s.substring(8);
            }
            System.out.print(s);
            for(int k=0;k<8-s.length();k++){
                System.out.print("0");
            }
            System.out.println();
        }
    }



}
