package com.andy.study.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @time: 2020/11/2 十一月 20:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        //客户端只需要一个事件循环组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap().group(workerGroup);
            bootstrap.channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            System.out.println("客户端准备好了");
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
            //注册关闭监听
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }
}
