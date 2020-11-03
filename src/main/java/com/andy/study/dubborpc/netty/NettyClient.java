package com.andy.study.dubborpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @time: 2020/11/3 十一月 22:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NettyClient {

    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    private static NettyClientHandler client;

    private int count = 0;


    //编写方法使用代理模式,获取一个代理对象
    public Object getBean(final Class<?> clz,final String protocol){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{clz},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("(proxy, method, args) 进入...." + (++count) + " 次");
                        //这段代码会反复执行
                        if(client==null){
                            initClient2();
                        }
                        //设置参数
                        client.setParam(protocol+args[0]);

                        Object s =  executor.submit(client).get();

                        return  s ;
                    }
                });
    }
    //初始化客户端
    private static void initClient(){
        client = new NettyClientHandler();
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)//不延迟
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(client);
                        }
                    });
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 7000).sync();
//            cf.channel().closeFuture().sync();
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            loopGroup.shutdownGracefully();
        }
    }


    //初始化客户端
    private static void initClient2() {
        client = new NettyClientHandler();
        //创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast(new StringDecoder());
                                pipeline.addLast(new StringEncoder());
                                pipeline.addLast(client);
                            }
                        }
                );

        try {
            bootstrap.connect("127.0.0.1", 7000).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
