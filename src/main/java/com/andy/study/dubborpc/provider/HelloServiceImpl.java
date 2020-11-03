package com.andy.study.dubborpc.provider;

import com.andy.study.dubborpc.service.HelloService;

/**
 * @time: 2020/11/3 十一月 21:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
        System.out.println("收到客户端消息:"+msg);
        String res = null;
        if(msg!=null){
            res = "你好客户端,我已经收到你的消息了["+msg+"]";
        }else{
            res = "你好客户端,我已经收到你的消息了";
        }

        return res;
    }
}
