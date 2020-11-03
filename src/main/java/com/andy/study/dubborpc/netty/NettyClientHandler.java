package com.andy.study.dubborpc.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @time: 2020/11/3 十一月 22:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private String result;//结构
    private String param;//客户端调用时传入的参数

    //与服务端建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
        System.out.println("客户端连接准备就绪");
    }

    //收到服务器的数据库 调用此方法
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端 channelRead");
        result = msg.toString();
        notify();//唤醒等待的线程
    }
    //出异常了
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.err.println("客户端出异常了");
    }

    //发送参数给服务器 等待返回结果后 被channelRead唤醒
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("调用call了");
        this.context.writeAndFlush(param);
        System.out.println("向服务器发送了参数"+param);
        wait();//等待  等channelRead方法唤醒之后再返回
        return result;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
