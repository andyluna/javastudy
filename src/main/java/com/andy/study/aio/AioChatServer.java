package com.andy.study.aio;

import java.io.Closeable;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @time: 2020/10/29 十月 22:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AioChatServer {
    public static final String DEFAULT_HOST="localhost";
    public static final int DEFAULT_PORT=8888;
    public static final String QUIT="quit";
    public static final int BUFFER=1024;
    public static final int THREAD_POOL_SIZE=8;

    private Charset charset = Charset.forName("UTF-8");
    private AsynchronousChannelGroup channelGroup;
    private AsynchronousServerSocketChannel serverSocketChannel;
    private String host;
    private int port;
    private List<ClientHandler> connectedClient;
    public AioChatServer(){
        this(DEFAULT_HOST,DEFAULT_PORT);
    }
    public AioChatServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.connectedClient = new CopyOnWriteArrayList<>();
    }


    /**
     * 主函数入口
     * @param args
     */
    public static void main(String[] args) {
        AioChatServer server = new AioChatServer("127.0.0.1",7777);
        server.start();
    }
    public void start(){
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
            serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverSocketChannel.bind(new InetSocketAddress(host, port));
            System.out.println("AIO服务器已经启动 正在监听["+port+"]端口");

            while(true){
                serverSocketChannel.accept(null,new AIOChatHandler());
                System.in.read();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(serverSocketChannel);
        }
    }
    public boolean readyToQuit(String msg){
        return QUIT.equals(msg);
    }
    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //连接成功处理器
    private class AIOChatHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            if(serverSocketChannel.isOpen()){
                serverSocketChannel.accept(null, this);
            }

            if(clientChannel!=null && clientChannel.isOpen()){
                ClientHandler handler = new ClientHandler(clientChannel);
                ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER);
                //TODO 将新用户保存至在线用户列表
                addClient(handler);
                clientChannel.read(byteBuffer, byteBuffer, handler);
            }

        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("连接失败:"+exc);
        }
    }

    //接收消息发送消息处理数据
    private class ClientHandler implements CompletionHandler<Integer, Object> {
        private AsynchronousSocketChannel clientChannel;
        public ClientHandler(AsynchronousSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer)attachment;
            if(buffer!=null){//读操作
                if(result<=0){//客户端异常
                    // TODO 将客户从在线列表移除
                }else{
                    buffer.flip();
                    String msg = receive(buffer);//解码
                    System.out.println(getClientName(clientChannel)+msg);//打印信息
                    forwardMessage(clientChannel,msg);//转发至在线用户列表
                    buffer.clear();
                    //检查用户是否退出
                    if(readyToQuit(msg)){
                        //将客户从在线客户列表中去除
                        removeClient(this);
                    }else{
                        //如果不是则继续等待读取用户输入的信息
                        clientChannel.read(buffer,buffer,this);
                    }
                }
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {

        }

    }



    /**
     * 添加一个新的客户端进客户端列表(list集合)
     * @param handler
     */
    private synchronized void addClient(ClientHandler handler) {
        connectedClient.add(handler);
        System.out.println(getClientName(handler.clientChannel)+"已经连接到服务器");
    }

    /**
     * 获取客户端的端口号并打印出来
     * @param clientChannel
     * @return
     */
    private String getClientName(AsynchronousSocketChannel clientChannel) {
        int clientPort = -1;
        try {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) clientChannel.getRemoteAddress();
            clientPort = inetSocketAddress.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "客户端["+clientPort+"]:";
    }

    // 接收消息
    private String receive(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return String.valueOf(charBuffer);
    }

    /**
     * 服务器端转发该客户发送的消息到其他客户控制室上(转发信息)
     * @param clientChannel
     * @param fwdMsg
     */
    private void forwardMessage(AsynchronousSocketChannel clientChannel, String fwdMsg) {
        for (ClientHandler handler:connectedClient){
            //该信息不用再转发到发送信息的那个人那
            if (!handler.clientChannel.equals(clientChannel)){
                try {
                    //将要转发的信息写入到缓冲区中
                    ByteBuffer buffer = charset.encode(getClientName(handler.clientChannel)+":"+fwdMsg);
                    //将相应的信息写入到用户通道中,用户再通过获取通道中的信息读取到对应转发的内容
                    handler.clientChannel.write(buffer,null,handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将该客户(下线)从列表中删除
     * @param clientHandler
     */
    private void removeClient(ClientHandler clientHandler) {
        connectedClient.remove(clientHandler);
        System.out.println(getClientName(clientHandler.clientChannel)+"已断开连接");
        //关闭该客户对应流
        close(clientHandler.clientChannel);
    }

}
