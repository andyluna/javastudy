package com.andy.study.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/11/1 23:31  星期日
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {
        //创建两个线程组 1个bossgroup 1个workergroup
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try {
            //创建服务端启动助手
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//设置服务端通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置连接活动保持状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//设置对应的管道处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            System.out.println("服务器 is ready");
            //绑定端口并且同步
            ChannelFuture cf = serverBootstrap.bind(6668).sync();

            cf.addListener(future -> {
                if(future.isSuccess()){
                    System.out.println("绑定 6668 成功");
                }else{
                    System.out.println("绑定 6668 失败");
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
