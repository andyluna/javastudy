package com.andy.study.jvm.stack;

/**
 * @time: 2020/10/24 十月 22:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class StackTest2 {

    private int length = 0;

    public void test1() {
        length++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test1();
    }


    public static void main(String[] args) {
        StackTest2 st = new StackTest2();
        try {
            st.test1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(st.length);
        }
    }

}
