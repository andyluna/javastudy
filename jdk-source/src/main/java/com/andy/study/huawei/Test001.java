package com.andy.study.huawei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * @time: 2021/3/12 三月 17:22
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test001 {
    public static void main(String[] args) {
        String s = getStr();
        String[] s1 = s.split(" ");
        System.out.println(s1[s1.length-1].length());
    }

    public static String getStr(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (s==null || s.trim().equals("")){
            s=sc.nextLine();
        }
        return s;
    }
}
