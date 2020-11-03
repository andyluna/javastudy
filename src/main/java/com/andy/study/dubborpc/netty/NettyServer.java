package com.andy.study.dubborpc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @time: 2020/11/3 十一月 22:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyServer {
    public static void startServer(String hostName,int port){
        startServer0(hostName,port);
    }
    private static void startServer0(String hostName,int port){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup wokerGroup = new NioEventLoopGroup(8);

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap().group(bossGroup, wokerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("myself", new NettyServerHandler());//业务处理类
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(hostName, port).sync();
            System.out.println("dubbo 服务器启动成功");
            ChannelFuture future = channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }

    }
}
