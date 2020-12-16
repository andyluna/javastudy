package com.andy.study.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/2 十一月 20:22
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    //当通道就绪调用此方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端 ctx " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,服务端", CharsetUtil.UTF_8));
    }

    //当通道有读事件时
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务端回复的消息是" + LocalDateTime.now() + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端地址" + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("出异常了");
        cause.printStackTrace();
    }
}
