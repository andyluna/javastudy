package com.liyi.study.base.day0423;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/23 12:46  星期五
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        for (Object obj:coll){
            System.out.println(obj);
        }
    }
}
