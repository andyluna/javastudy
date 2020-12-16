package com.andy.study.util;

import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/8 0:02  星期四
 */
public class MapTest {

    @Test
    public void testHashMap() {
        int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println(MAXIMUM_CAPACITY * 2 - 1);
        int MAXIMUM_CAPACITY1 = 1 << 31;
        System.out.println(MAXIMUM_CAPACITY1);

        int MAXIMUM_CAPACITY2 = 1 << 32;
        System.out.println(MAXIMUM_CAPACITY1);


        int a = 1;
        int b = 2;
        System.out.println(a);
        System.out.println(b);
        a = b = 3;

        System.out.println(a);
        System.out.println(b);
    }


}
