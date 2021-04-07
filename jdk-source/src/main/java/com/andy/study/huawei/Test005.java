package com.andy.study.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test005 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext()) {
            System.out.println(Integer.parseInt(sr.nextLine().substring(2),16));
        }
    }



}
