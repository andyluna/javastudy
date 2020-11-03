package com.andy.study.dubborpc.netty;

import com.andy.study.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.andy.study.dubborpc.consumer.ClientBootStrap.PROTOCOL;

/**
 * @time: 2020/11/3 十一月 22:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
//    //获取客户端发送的消息并调用服务
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("服务端收到的消息:"+msg);
//        //客户端在调用服务器的API需要自定义一个协议  消息已某个固定字符串开头"HelloService#hello#"
//
//        if(msg!= null && msg.toString().startsWith(PROTOCOL)){
//            HelloServiceImpl service = new HelloServiceImpl();
//            String res = msg.toString().substring(msg.toString().lastIndexOf("#")+1 );
//            String s = service.sayHello(res);//消息调用结果
//            System.out.println("服务端向客户端返回了  "+s);
//            ctx.writeAndFlush(s);
//        }
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("服务端收到的消息:"+msg);
        //客户端在调用服务器的API需要自定义一个协议  消息已某个固定字符串开头"HelloService#hello#"

        if(msg!= null && msg.toString().startsWith(PROTOCOL)){
            HelloServiceImpl service = new HelloServiceImpl();
            String res = msg.toString().substring(msg.toString().lastIndexOf("#")+1 );
            String s = service.sayHello(res);//消息调用结果
            System.out.println("服务端向客户端返回了  "+s);
            ctx.writeAndFlush(s);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("服务端出异常了");
    }
}
