package com.andy.study.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @time: 2020/10/27 十月 20:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ServerSokectTest {
    public static final String QUIT = "quit";
    public static final int DEFAULT_PORT = 8888;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        ServerSokectTest serverSocket = new ServerSokectTest();
        serverSocket.init(DEFAULT_PORT);
        System.in.read();
    }


    public void init(int port)  {
        ServerSocket serverSocket = null;
        ExecutorService executorService = null;
        try{
            //executorService = Executors.newFixedThreadPool(3);

            executorService = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(100)) ;
            serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true); //设置 ServerSocket 的选项
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("server 启动 监听:"+port+"端口");
            while(true){
                Socket socket = serverSocket.accept();
                executorService.submit(new HandlerThread(socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(executorService!=null){
                executorService.shutdown();
            }
        }

    }

    private class HandlerThread implements Runnable{
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            count.incrementAndGet();
            System.out.println("第"+count.get()+"个客户端连接成功,端口:"+socket.getPort()+" "+socket.getInetAddress());
        }

        @Override
        public void run() {
            BufferedReader in  = null;
            BufferedWriter out = null;
            try {
                // 读取客户端数据
                in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String str = null;
                while((str=in.readLine()) != null){
                    System.out.println("客户端["+count.get()+"端口:"+socket.getPort()+"]发送过来的消息:"+str);
                    out.write("服务端:"+str+"! ");
                    out.newLine();
                    out.flush();
                    if(QUIT.equals(str)){
                        break;
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("服务器 run 异常: " + e.getMessage());
            } finally {
                if(in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    System.out.println("第"+count.get()+"开始关闭,端口:"+socket.getPort()+" "+socket.getInetAddress());
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }

        public void start(){
            new Thread(this).start();
        }
    }

}
