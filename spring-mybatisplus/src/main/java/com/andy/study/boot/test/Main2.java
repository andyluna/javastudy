package com.andy.study.boot.test;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @time: 2021/2/21 二月 11:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str==null){
            throw new RuntimeException("请输入停车位");
        }
        String[] split = str.split(",");
        if(split.length>2){
            throw new RuntimeException("只能输入URL前缀和后缀");
        }
        String res = null;
        if(split.length==0){
            res = "/";
        }else{
            String prefix = split[0];
            String suffix = split[1];

            if(prefix.endsWith("/")){
                prefix = prefix.substring(0, prefix.length()-1);
            }

            if(!suffix.startsWith("/")){
                suffix = "/"+suffix;
            }

            res =  prefix+suffix;
        }

        System.out.println(res);
    }


}
