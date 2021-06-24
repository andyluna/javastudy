package com.liyi.study.base.day0425;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 22:55  星期日
 */
public class StreamAPITest {


    @Test
    public void test1(){

        List<String> list= Arrays.asList("aa","bb","cc");



    }

    public static void formStringToStream(String str){
        ArrayList<Character> list=new ArrayList<>();

        for (Character c:str.toCharArray()){
            list.add(c);
        }

    }



}
