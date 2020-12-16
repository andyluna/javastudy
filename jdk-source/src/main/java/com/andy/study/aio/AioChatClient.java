package com.andy.study.aio;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @time: 2020/10/29 十月 22:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AioChatClient {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8888;
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;
    private String host;
    private int port;

    private AsynchronousSocketChannel clientChannel;
    private Charset charset = Charset.forName("utf-8");


    public AioChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public AioChatClient() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static void main(String[] args) {
        AioChatClient chatClient = new AioChatClient("127.0.0.1", 7777);
        chatClient.start();
    }

    private void start() {
        try {
            //创建channel
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(host, port));
            future.get();//阻塞式调用
            System.out.println("客户端" + clientChannel.getLocalAddress() + "连接服务器" + clientChannel.getRemoteAddress() + "成功");

            //启动一个新的线程用于处理用户的输入
            new Thread(new UserInputHandler(this)).start();

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
            //读取从服务器中转发的消息
            while (true) {
                //启动异步读操作,从该通道读取到给定的缓冲区字节序列
                Future<Integer> readResult = clientChannel.read(buffer);
                //Future的get方法返回从通道中读取的字节数的大小
                int result = readResult.get();
                if (result <= 0) {
                    //无法从服务器读取到信息,服务器异常
                    System.out.println("服务器断开");
                    //同时将客户端也关闭
                    close(clientChannel);
                    //0是正常退出,非0是不正常退出
                    break;
                } else {
                    //将读模式转换为写模式
                    buffer.flip();
                    String msg = String.valueOf(charset.decode(buffer));
                    //每次将缓冲区的内容写出来后都将缓冲区数据清空
                    buffer.clear();
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            close(clientChannel);
        }
    }

    /**
     * 用户将消息发送给服务器
     *
     * @param msg
     */
    public void send(String msg) {
        if (msg.isEmpty()) {
            //未输入信息,没有必要向服务发送内容
            return;
        }
        //将要发送的数据进行utf-8加码
        ByteBuffer buffer = charset.encode(msg);
        //将要发送的数据写入缓冲区中
        Future<Integer> writeResult = clientChannel.write(buffer);
        try {
            writeResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("消息发送失败");
            e.printStackTrace();
        }
    }


    /**
     * 当输入"quit"时表示客户退出
     *
     * @param msg
     * @return
     */
    public boolean readyToQuit(String msg) {
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


    private class UserInputHandler implements Runnable {
        private AioChatClient aioChatClient;

        public UserInputHandler(AioChatClient aioChatClient) {
            this.aioChatClient = aioChatClient;
        }

        @Override
        public void run() {
            try {
                //等待用户输入消息
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String input = br.readLine();
                    //向服务器发送消息
                    aioChatClient.send(input);
                    //检查用户是否准备退出
                    if (aioChatClient.readyToQuit(input)) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
