package com.andy.study.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 当没有新的输入时，说明输入结束。
 输入描述:
 注意：输入可能有多组数据(用于不同的调查)。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test003 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        List<Set<Integer>> as = new ArrayList<>();
        while (sr.hasNext()) {
            int n = sr.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(sr.nextInt());
            }
            as.add(set);
        }

        for(Set<Integer> nn:as){
            for(Integer n:nn){
                System.out.println(n);
            }
        }
    }



}
