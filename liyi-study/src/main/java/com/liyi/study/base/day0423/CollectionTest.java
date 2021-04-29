package com.liyi.study.base.day0423;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 11:12  星期五
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

//        Person p=new Person("Jerry",20);
//        coll.add(p);

        //判断当前集合是否含有obj
        boolean contains=coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry",20)));

//        System.out.println(coll.contains(p));

        Collection coll1= Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        boolean b1=coll.remove(123);
        boolean b2=coll.remove(1234);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(coll);

        //removeAll(Collection coll):从当前集合移除coll中的所有元素
        Collection coll1= Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);

        System.out.println(coll.hashCode());

    }

    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //集合--->数组
        Object[] arr=coll.toArray();
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        List<String> list=Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

    }

    @Test
    public void test4(){

        Set set=new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",22));
        set.add(199);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test5(){
        Set set=new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",22));
        set.add(199);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test6(){
        TreeSet treeSet=new TreeSet();

        treeSet.add(123);
        treeSet.add(654);
//        treeSet.add("eea");
        System.out.println(treeSet);

    }
}
