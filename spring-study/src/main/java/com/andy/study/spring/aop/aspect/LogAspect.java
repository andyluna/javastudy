package com.andy.study.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.util.Arrays;

/**
 * @time: 2020/11/24 十一月 22:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class LogAspect {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
    public void beforeLog(JoinPoint jp){
        log.debug("方法执行之前name - {} - {}",name,jp.getClass(),jp);
        MethodInvocationProceedingJoinPoint mejp = (MethodInvocationProceedingJoinPoint) jp;
        Object target = mejp.getTarget();
        Signature signature = mejp.getSignature();
        Object[] args = mejp.getArgs();
        int id = mejp.getId();
        String kind = mejp.getKind();
        SourceLocation sourceLocation = mejp.getSourceLocation();
        JoinPoint.StaticPart staticPart = mejp.getStaticPart();
        log.debug("方法执行之前target         = {}",target);
        log.debug("方法执行之前signature      = {}",signature);
        log.debug("方法执行之前args           = {}", Arrays.toString(args));
        log.debug("方法执行之前id             = {}",id);
        log.debug("方法执行之前kind           = {}",kind);
        log.debug("方法执行之前sourceLocation = {}",sourceLocation);
        log.debug("方法执行之前staticPart     = {}",staticPart);
    }
}
