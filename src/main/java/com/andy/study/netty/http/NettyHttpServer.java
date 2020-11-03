package com.andy.study.netty.http;

import com.andy.study.netty.simple.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @time: 2020/11/2 十一月 21:34
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyHttpServer {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组 1个bossgroup 1个workergroup
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try {
            //创建服务端启动助手
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(null)//对应bossGroup
                    .childHandler(new NettyHttpServerInitializer());//对应workerGroup

            System.out.println("Http server is ready");
            //绑定端口并且同步
            ChannelFuture cf = serverBootstrap.bind(6669).sync();

            cf.addListener(future -> {
                if(future.isSuccess()){
                    System.out.println("绑定 6669 成功");
                }else{
                    System.out.println("绑定 6669 失败");
                }
            });

            //对关闭通道进行监听
            ChannelFuture sync = cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
