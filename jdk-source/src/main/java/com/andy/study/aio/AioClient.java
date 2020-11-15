package com.andy.study.aio;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @time: 2020/10/29 十月 22:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AioClient {
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8888;
    private String host;
    private int port;

    private AsynchronousSocketChannel socketChannel = null;
    public AioClient(){
        this(DEFAULT_HOST,DEFAULT_PORT);
    }
    public AioClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        AioClient aioClient = new AioClient();
        aioClient.start();
    }

    public void start(){
        try {
            //创建channel
            socketChannel = AsynchronousSocketChannel.open();

            Future<Void> future = socketChannel.connect(new InetSocketAddress(host, port));
            future.get();//阻塞试调用
            System.out.println("客户端["+socketChannel.getLocalAddress()+"]连接服务端"+socketChannel.getRemoteAddress()+"成功");

            //等待用户输入
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while (true){
                line = br.readLine();
                byte[] bytes = line.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(bytes);
                Future<Integer> writeFuter = socketChannel.write(buffer);

                writeFuter.get();

                buffer.flip();
                buffer.clear();

                Future<Integer> read = socketChannel.read(buffer);

                read.get();
                String echo = new String(buffer.array());
                System.out.println("服务器返回:"+echo);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            close(socketChannel);
        }
    }

    private void close(Closeable closeable) {
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
