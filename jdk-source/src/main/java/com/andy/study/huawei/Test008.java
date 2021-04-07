package com.andy.study.huawei;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * @time: 2021/3/12 三月 17:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Test008 {


    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            String s1 = scanner.nextLine();
            String[] s = s1.split(" ");
            Integer key = Integer.parseInt(s[0]);
            Integer value = Integer.parseInt(s[1]);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+value);
            }else{
                map.put(key,value);
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
    public static void test2(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // TreeMap中键值会自动按照升序排列
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        while(num>0){
            Integer keyIn = sc.nextInt();
            //如果map中包含有key值，则更新此key值对用的value值;否则不更新，直接将此key-value
            //put进map中；
            if(map.containsKey(keyIn)){
                Integer val = map.get(keyIn)+sc.nextInt();
                map.put(keyIn,val);
            }else{
                map.put(keyIn,sc.nextInt());
            }
            //控制循环结束
            num--;
        }
        //使用Iterator遍历Map
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> en =(Map.Entry<Integer,Integer>)iterator.next();
            Integer key = en.getKey();
            Integer val = en.getValue();
            System.out.println(key+" "+val);
        }
    }

}
