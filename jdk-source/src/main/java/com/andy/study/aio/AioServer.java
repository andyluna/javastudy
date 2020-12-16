package com.andy.study.aio;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @time: 2020/10/29 十月 21:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AioServer {
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8888;

    private AsynchronousServerSocketChannel serverSocketChannel = null;


    private String host;
    private int port;

    public AioServer() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public AioServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        AioServer aioServer = new AioServer();
        aioServer.start();
    }

    public void start() {
        try {
            //绑定监听端口
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("服务端启动成功");

            while (true) {
                serverSocketChannel.accept(null, new AcceptHandler(serverSocketChannel));
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(serverSocketChannel);
        }
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

    //接收时间处理器
    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
        private AsynchronousServerSocketChannel serverChannel;

        public AcceptHandler(AsynchronousServerSocketChannel serverChannel) {
            this.serverChannel = serverChannel;
        }

        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            try {
                System.out.println("客户端[" + clientChannel.getRemoteAddress() + "]连接成功");
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (serverChannel.isOpen()) {
                serverChannel.accept(null, this);
            }
            if (clientChannel != null && clientChannel.isOpen()) {
                ClientHandler handler = new ClientHandler(clientChannel);
                ByteBuffer buffer = ByteBuffer.allocate(10);
                Map<String, Object> info = new HashMap<>();
                info.put("type", "read");
                info.put("buffer", buffer);
                clientChannel.read(buffer, info, handler);

            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("出异常了");
        }
    }

    //读写时间处理器
    private class ClientHandler implements CompletionHandler<Integer, Object> {
        private AsynchronousSocketChannel socketChannel = null;

        public ClientHandler(AsynchronousSocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            Map<String, Object> info = (Map<String, Object>) attachment;
            String type = (String) info.get("type");
            if ("read".equals(type)) {
                ByteBuffer buffer = (ByteBuffer) info.get("buffer");
                buffer.flip();

                info.put("type", "write");
                socketChannel.write(buffer, info, this);
                buffer.clear();
            } else if ("write".equals(type)) {
                ByteBuffer buffer = ByteBuffer.allocate(10);
                Map<String, Object> info2 = new HashMap<>();
                info2.put("type", "read");
                info2.put("buffer", buffer);
                socketChannel.read(buffer, info2, this);
            }

        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("ClientFailed");
        }
    }

}
