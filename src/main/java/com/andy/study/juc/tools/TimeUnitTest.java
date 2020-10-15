package com.andy.study.juc.tools;

import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 15:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class TimeUnitTest {
    public static void main(String[] args) {
        long l = TimeUnit.SECONDS.toMillis(3);
        System.out.println(l);


        long convert = TimeUnit.SECONDS.convert(300, TimeUnit.MILLISECONDS);

        System.out.println(convert);

    }

}
