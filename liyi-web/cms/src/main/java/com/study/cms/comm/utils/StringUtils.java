package com.study.cms.comm.utils;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 22:09  星期三
 */
public class StringUtils {



    public static boolean isEmpty(Object str){
        return str==null|| str.toString().trim().length()==0;
    }
}
