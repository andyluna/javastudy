package com.andy.study.dubborpc.consumer;

import com.andy.study.dubborpc.netty.NettyClient;
import com.andy.study.dubborpc.service.HelloService;

/**
 * @time: 2020/11/3 十一月 22:45
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ClientBootStrap {
    public static final String PROTOCOL = "HelloService#hello#";
    public static void main(String[] args) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();
        System.out.println("开始");
        HelloService helloService = (HelloService) nettyClient.getBean(HelloService.class, PROTOCOL);
        System.out.println("service "+helloService.getClass() );

        //System.out.println("helloService = "+helloService);
        for(int i =0;i<10;i++){
            Thread.sleep(2 * 1000);
            String s = helloService.sayHello("你好,dubbo~");
            System.out.println("调用结果 "+s+" \n");
        }


    }


}
