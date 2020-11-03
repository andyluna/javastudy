package com.andy.study.dubborpc.provider;

import com.andy.study.dubborpc.netty.NettyServer;

/**
 * @time: 2020/11/3 十一月 22:03
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ServerBootStrap {
    //启动服务提供者
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",7000);
    }
}
