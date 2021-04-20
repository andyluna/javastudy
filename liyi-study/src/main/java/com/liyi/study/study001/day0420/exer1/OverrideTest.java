package com.liyi.study.study001.day0420.exer1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 8:37  星期二
 */
public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test=new OverrideTest();
        test.display(new SubClass());
    }


    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class SuperClass{
    public void method() throws IOException{

    }


}

class SubClass extends SuperClass{
    public void method() throws FileNotFoundException{

    }
}

