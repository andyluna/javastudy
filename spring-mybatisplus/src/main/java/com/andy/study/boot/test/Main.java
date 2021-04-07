package com.andy.study.boot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @time: 2021/2/21 二月 11:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str==null){
            throw new RuntimeException("请输入停车位");
        }
        String[] split = str.split(",");
        if(split.length>100){
            throw new RuntimeException("停车位最多只能有100个");
        }
        Long zeroCount = Stream.of(split).filter(f -> "0".equals(f))
                .collect(Collectors.counting());

        if(zeroCount<1){
            throw new RuntimeException("至少有一个空车位");
        }
        Long oneCount = Stream.of(split).filter(f -> "1".equals(f))
                .collect(Collectors.counting());
        if(oneCount<1){
            throw new RuntimeException("至少有一辆车停在车位上");
        }
        int res = 0;

        for(int i=0;i<split.length;i++){
            String j = split[i];
            if("1".equals(j)){
                continue;
            }
            int res1 = 0;
            int res2 = 0;
            int k = i-1;
            while(k>=0){
                if("1".equals(split[k])){
                    res1 = i-k >res1 ?i-k:res1;
                    k =0;
                }
                k--;
            }
            int m = i+1;
            while(m<split.length){
                if("1".equals(split[m])){
                    res2 = m-i >res2 ?m-i:res2;
                    m = split.length;
                }
                m++;
            }


            res1 = res1>res2?res2:res1;
            res = res1>res?res1:res;

        }



        System.out.println(res);


    }


}
