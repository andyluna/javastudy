package com.liyi.study.base.day0425;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 21:02  星期日
 */
interface Human{
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can Fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}


class ProxyFactory{
    public static Object getProxyInstance(Object obj){


        MyInvocationHandler invocationHandler =new MyInvocationHandler() ;

        invocationHandler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),invocationHandler);

    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object returnValue = method.invoke(obj, args);

        return returnValue;
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan=new SuperMan();

        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");


    }


}
