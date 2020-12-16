package com.andy.study.jvm.stack;

/**
 * TODO:
 *
 * @time: 2020/9/29 九月 10:07
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest st = new StackTest();
        st.method1();
    }

    private void method1() {
        int a = 1;
        int b = 1;

        method2();
    }

    private void method2() {
        int a = 1;
        int b = 1;
    }


}
