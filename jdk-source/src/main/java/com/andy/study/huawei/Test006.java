package com.andy.study.huawei;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = 0;
        if (scanner.hasNextLong()) {
            number = scanner.nextLong();
            canculate(number);
        }
    }


    public static void canculate(long num){
        for(long i=2;i<=num;i++){
            if(num%i==0){
                System.out.print(i+" ");
                canculate(num/i);
                return;
            }
        }
    }
    private static void isPrimerFactors(long num) {
        long number = num;
        while (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println("之前:"+number);
                    number /= i;
                    System.out.print(i + " ");
                    System.out.println("之后:"+number);
                    break;
                }
            }
        }
    }


}
