package com.andy.study.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @time: 2020/10/28 十月 21:08
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ChatServer {
    private final int DEFAULT_PORT= 8888;
    private final String QUIT = "quit";
    private ServerSocket serverSocket = null;
    private Map<Integer, Writer> connectClients = null;
    private ExecutorService executorService = null;
    private String lineSeparator = null;
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();

    }

    public ChatServer() {
        connectClients = new ConcurrentHashMap<>();
        executorService = new ThreadPoolExecutor(3, 5,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        lineSeparator = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction("line.separator"));
    }

    public void addClient(Socket socket) throws IOException {
        if(socket != null){
            int port = socket.getPort();
            OutputStream out;
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            connectClients.put(port, br);
            System.out.println("客户端["+port+"]连接服务器成功");
        }
    }

    public void removeSocket(Socket socket) throws IOException {
        if(socket != null){
            int port = socket.getPort();
            if(connectClients.containsKey(port)){
                Writer writer = connectClients.get(port);
                writer.close();
                connectClients.remove(port);
                socket.close();
                System.out.println("客户端["+port+"]断开服务器");
            }
        }
    }

    public boolean readyToQuit(String msg){
        return QUIT.equals(msg);
    }

    public void forwardMessage(Socket socket, String fwdMessage) throws IOException {
        for(Integer port:connectClients.keySet()){
            if(!port.equals(socket.getPort())){
                Writer writer = connectClients.get(port);
                writer.write(fwdMessage);
                if(!fwdMessage.endsWith(lineSeparator)){
                    writer.write(lineSeparator);
                }
                writer.flush();
            }
        }
    }

    public void start(){
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("服务端启动成功,监听端口:"+DEFAULT_PORT);
            while (true){
                Socket socket = serverSocket.accept();
                ChatHandler handler = new ChatHandler(this, socket);
                executorService.submit(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void close(){
        if(serverSocket!=null){
            try {
                System.out.println("服务端关闭");
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
