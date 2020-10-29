package com.andy.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @time: 2020/10/29 十月 19:10
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NioChatServer {
    private static final int DEFAULT_PORT= 8888;
    private final String QUIT = "quit";
    private static final int BUFFER = 1024;

    private ServerSocketChannel serverSocketChannel = null;
    private Selector selector = null;
    private ByteBuffer readBuffer  = ByteBuffer.allocate(BUFFER);//读buffer
    private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER);//写buffer
    private Charset charset = Charset.forName("UTF-8");
    private int port;


    public static void main(String[] args) {
        NioChatServer server = new NioChatServer(7777);
        server.start();
    }
    public NioChatServer(){
        this(DEFAULT_PORT);
    }
    public NioChatServer(int port) {
        this.port = port;
    }

    public void start(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);//设置非阻塞式调用
            serverSocketChannel.socket().bind(new InetSocketAddress(port));//绑定端口

            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("NIO服务端启动成功,监听端口:"+port);


            while (true) {
                int select = selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                for (SelectionKey key:selectionKeys){
                    //处理被触发事件
                    handles(key);
                }

                selectionKeys.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void handles(SelectionKey key) throws IOException {
        //ACCEPT事件-和客户端建立了连接
        if(key.isAcceptable()){
            System.out.println("连接事件");
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();//客户端通道
            client.configureBlocking(false);//非阻塞
            client.register(selector, SelectionKey.OP_READ);
            System.out.println(getClientName(client)+"已连接到服务器");
        }
        //READ事件-客户端发送了消息
        else if(key.isReadable()){
            System.out.println("读取数据事件");
            SocketChannel client = (SocketChannel) key.channel();
            String fwdMsg = recevie(client);
            System.out.println("读取到的内容:"+fwdMsg);
            if(fwdMsg.isEmpty()){
                key.cancel();//客户端异常
                selector.wakeup();//
            }else{
                forwardMessage(client,fwdMsg);//向其他客户端发送消息
                //检查用户是否退出
                if(readyToQuit(fwdMsg)){
                    key.cancel();//客户端异常
                    selector.wakeup();//
                    System.out.println(getClientName(client)+" 断开连接");
                }
            }
        }
    }

    private String recevie(SocketChannel client) throws IOException {
        readBuffer.clear();
        while(client.read(readBuffer)>0);
        readBuffer.flip();
        return String.valueOf(charset.decode(readBuffer));
    }



    private String getClientName(SocketChannel channel){
        return "客户端["+channel.socket().getPort()+"]";
    }


    public boolean readyToQuit(String msg){
        return QUIT.equals(msg);
    }

    public void forwardMessage(SocketChannel socket, String fwdMessage) throws IOException {
        for(SelectionKey key:selector.keys()){
            Channel channel = key.channel();
            if(channel instanceof ServerSocketChannel){
                continue;
            }
            if(key.isValid() && !channel.equals(socket)){
                writeBuffer.clear();
                writeBuffer.put(charset.encode(getClientName((SocketChannel) channel)+fwdMessage));
                writeBuffer.flip();
                while (writeBuffer.hasRemaining()){
                    ((SocketChannel) channel).write(writeBuffer);
                }
            }
        }
    }



    public void close(){
        if(selector!=null){
            try {
                selector.close();
                System.out.println("服务端关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /** 关闭selector 能顺便关闭channel
        if(serverSocketChannel!=null){
            try {
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         */
    }

}
