package com.andy.study.huawei;

import java.util.Locale;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，
 * 和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        String s2 = sc.next();
        char[] chars = s.toCharArray();
        int n = 0;
        if(chars!=null && chars.length>0) {
            for (int i = 0; i < chars.length; i++) {
                if (s2.equalsIgnoreCase(chars[i] + "")) {
                    n++;
                }
            }
        }
        System.out.println(n);
    }


}
