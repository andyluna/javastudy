package com.andy.study.huawei;

import java.util.Scanner;

/**
 *  写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double number = 0d;
        while (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
            System.out.println(Math.round(number));
        }
    }


}
