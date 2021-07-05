package com.liyi.spring.spring5.config;

import com.liyi.spring.spring5.dao.UserDao;
import com.liyi.spring.spring5.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/2 9:25  星期五
 */
public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces={UserDao.class};

        UserDaoImpl userDao=new UserDaoImpl();
                                                             //类加载器                    接口            InvocationHandler
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        dao.update();
    }
}


//创建代理对象
class UserDaoProxy implements InvocationHandler{

    //把要创建代理对象的传递过来
    //1.有参构造
    private Object obj;
    public UserDaoProxy (Object obj){
        this.obj=obj;
    }


    //对象创建就会调用invoke()方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行"+method.getName()+"传递的参数:"+ Arrays.toString(args));

        //被增强的方法
        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("方法之后执行"+obj);
        return res;
    }
}
