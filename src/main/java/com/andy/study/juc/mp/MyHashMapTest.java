package com.andy.study.juc.mp;

import java.util.HashMap;
import java.util.Map;

/**
 * @time: 2020/10/26 十月 10:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyHashMapTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
        map.put("5", "2");

        Map<String,String> map2 = new HashMap<>(map);

    }


}
