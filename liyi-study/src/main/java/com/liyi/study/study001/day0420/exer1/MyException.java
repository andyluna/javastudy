package com.liyi.study.study001.day0420.exer1;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 9:10  星期二
 */
public class MyException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;


    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }


}
