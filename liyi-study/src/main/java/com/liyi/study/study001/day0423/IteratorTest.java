package com.liyi.study.study001.day0423;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 12:14  星期五
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator= coll.iterator();

//        for(int i=0;i<coll.size();i++){
//            System.out.println(iterator.next());
//        }

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }


    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        Iterator iterator= coll.iterator();
        //删除集合中的"Tom"
        while (iterator.hasNext()){
            //获取每个next的值用obj存储
            Object obj=iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }

        iterator= coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
