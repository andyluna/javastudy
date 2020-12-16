package com.andy.study.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * @time: 2020/11/2 十一月 21:36
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //获取管道
        ChannelPipeline pipeline = ch.pipeline();
        //加入netty提供的一个HttpServerCodec 编码解码器

        pipeline.addLast("myHttpServerCodec", new HttpServerCodec());

        pipeline.addLast("myHttpServerHandler", new NettyHttpServerHandler());
        System.out.println("ok~~~~");
    }
}
