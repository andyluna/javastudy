package com.andy.study.nio;


import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @time: 2020/10/29 十月 20:35
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NioChatClient {

    private static final int DEFAULT_PORT = 8888;
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;

    private String host;
    private int port;

    private SocketChannel client = null;
    private Selector selector = null;
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER);//读buffer
    private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER);//写buffer
    private Charset charset = Charset.forName("UTF-8");

    public NioChatClient() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public NioChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        NioChatClient client = new NioChatClient("127.0.0.1", 7777);
        client.start();
    }

    //发送消息
    public void sendMessage(String message) throws IOException {
        if (message.isEmpty()) {
            return;
        }
        writeBuffer.clear();
        writeBuffer.put(charset.encode(message));
        writeBuffer.flip();
        while (writeBuffer.hasRemaining()) {
            client.write(writeBuffer);
        }
        //检查用户是否退出
        if (readToQuit(message)) {
            close(selector);
        }
    }

    //接收消息
    public String receive(SocketChannel socketChannel) throws IOException {
        readBuffer.clear();
        while (socketChannel.read(readBuffer) > 0) ;
        readBuffer.flip();
        return String.valueOf(charset.decode(readBuffer));
    }


    public void start() {
        try {
            // 创建Client socketChannel
            client = SocketChannel.open();
            client.configureBlocking(false);
            selector = selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);

            boolean connect = client.connect(new InetSocketAddress(host, port));

            System.out.println("客户端[" + client.socket().getPort() + "]连接成功");

            while (selector.isOpen()) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    handles(key);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClosedSelectorException e) {
            //用户正常退出
        } finally {
            close(selector);
        }
    }

    private void handles(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        //连接就绪事件
        if (key.isConnectable()) {
            if (channel.isConnectionPending()) {//连接就绪状态
                channel.finishConnect();
                //处理用户输入
                new Thread(new NioClientIputHandler(this)).start();
            }
            client.register(selector, SelectionKey.OP_READ);
        }
        //可读事件
        else if (key.isReadable()) {
            String msg = receive(client);
            if (msg.isEmpty()) {
                //服务器关闭
                close(selector);
            } else {
                System.out.println(msg);
            }
        }


    }

    //检查用户是否退出
    public boolean readToQuit(String message) {
        return QUIT.equals(message);
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
