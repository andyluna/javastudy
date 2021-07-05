package com.liyi.spring.spring5.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 23:59  星期日
 */
public class MaipiaoDaili {

    public void train1before(JoinPoint jp){
        Signature signature = jp.getSignature();
        System.out.println("在方法执行之前"+jp.getSignature().getName());
    }

    public String train1After(JoinPoint jp){
        System.out.println("在方法执行之后"+jp.toLongString());
        return "1110";
    }

}
