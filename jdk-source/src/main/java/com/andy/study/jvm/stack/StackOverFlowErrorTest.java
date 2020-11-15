package com.andy.study.jvm.stack;

/**
 * TODO:
 *  默认情况下   等于 10822
 *  -Xss256k   等于 1873
 * @time: 2020/9/29 九月 10:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class StackOverFlowErrorTest {

    private static int count =0;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }


}
