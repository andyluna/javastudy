package com.liyi.spring.spring5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 23:34  星期日
 */
public class MapPiaoInvocationHandler implements InvocationHandler {

    private Maipiao mp;

    public MapPiaoInvocationHandler(Maipiao mp) {
        this.mp = mp;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        try{
            System. out.println("执行方法"+method.toString()+"之前,参数是"+args);
            res = method.invoke(mp, args);


        }catch (Exception e){

        } finally {
            System.out.println("执行方法"+method.toString()+"之后,返回结果是"+res);
        }
        return res;
    }




}
