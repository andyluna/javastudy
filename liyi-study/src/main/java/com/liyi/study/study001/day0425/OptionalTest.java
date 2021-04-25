package com.liyi.study.study001.day0425;

import org.junit.Test;

import java.util.Optional;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 23:27  星期日
 */
public class OptionalTest {


    @Test
    public void test1() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;

        Optional<Girl> optionalGirl = Optional.ofNullable(girl);

        System.out.println(optionalGirl);
    }

    public String getGirlName(Boy boy){

        return boy.getGirl().getName();

    }

    @Test
    public void test3(){
        Boy boy=new Boy();
        String girlName=getGirlName(boy);
        System.out.println(girlName);
    }

    @Test
    public void test4(){
        Girl girl=new Girl();
        girl=null;

        Optional<Girl> optionalGirl=Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        Girl girl1=optionalGirl.orElse(new Girl("小花"));
        System.out.println(girl1);
    }


    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional=Optional.ofNullable(boy);

        Boy boy1=boyOptional.orElse(new Boy(new Girl("花花")));

        Girl girl=boy1.getGirl();

        Optional<Girl> girlOptional=Optional.ofNullable(girl);

        Girl girl1=girlOptional.orElse(new Girl("草草"));

        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy=null;
        boy=new Boy();
        boy=new Boy(new Girl("???"));
        String girlName=getGirlName2(boy);
        System.out.println(girlName);


    }

}
