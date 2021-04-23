package com.liyi.study.study001.day0423;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 18:48  星期五
 */
public class MapTest {

    @Test
    public void test1(){

        Map map=new HashMap();
        map.put(null,null);
        map.put("ab",123);
        System.out.println(map);

//        map=new Hashtable();
//        map.put(null,123);      NullPointerException

    }


    @Test
    public void test2(){
        Map map=new HashMap();
        //添加
        map.put("AA",123);
        map.put("bb",123);
        map.put(45,123);

        //修改
        map.put("AA",666);
        System.out.println(map);


        Map map1=new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map1.putAll(map);
        System.out.println(map1);

        //remove(Object key)
        Object value=map.remove("AA");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();
        System.out.println(map.size());
        System.out.println(map);

    }


    @Test
    public void test3(){
        Map map=new HashMap();

        map.put("AA",123);
        map.put("bb",123);
        map.put(45,123);

        System.out.println(map.get(45));

        System.out.println(map.containsKey("BB"));

        System.out.println(map.containsKey("bb"));

        System.out.println(map.containsValue(123));
    }

    @Test
    public void test4(){
        Map map=new HashMap();

        map.put("AA",1234);
        map.put("bb",1235);
        map.put(45,12366);

       Set set=map.keySet();
       Iterator iterator=set.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }

       Collection coll=map.values();
       for (Object obj:coll){
           System.out.println(obj);
       }


       //方式1
       Set s1=map.entrySet();
       Iterator iterator1=s1.iterator();
       while (iterator1.hasNext()){
           Object obj=iterator1.next();
           Map.Entry entry=(Map.Entry)obj;
           System.out.println(entry.getKey()+"  "+entry.getValue());
       }

       //方式2
        Set set1=map.keySet();
        Iterator iterator2=set1.iterator();
        while (iterator2.hasNext()){
            Object key=iterator2.next();
            Object value=map.get(key);
            System.out.println(key+"---"+value);
        }

    }



}
