package com.andy.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @time: 2020/10/28 十月 21:42
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ChatClient {

    private final int port = 8888;
    private final String host = "127.0.0.1";
    private final String QUIT = "quit";
    private String lineSeparator = null;

    private Socket socket = null;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;

    public ChatClient(){
        lineSeparator = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction("line.separator"));
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.start();
    }

    //发送消息
    public void sendMessage(String message) throws IOException {
        if(!socket.isOutputShutdown()){
            writer.write(message);
            if(!message.endsWith(lineSeparator)){
                writer.write(lineSeparator);
            }
            writer.flush();
        }
    }

    //接收消息
    public String receive() throws IOException {
        String message = null;
        if(!socket.isInputShutdown()){
            message = reader.readLine();
        }
        return message;
    }
    //检查用户是否退出

    public boolean readToQuit(String message){
        return QUIT.equals(message);
    }

    public void start(){
        try {
            // 创建socket
            socket = new Socket(host,port);
            // 创建IO流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //处理用户输入
            new Thread(new ChatClientInputHandler(this)).start();
            //读取服务器返回的消息
            String msg = null;
            while((msg=receive())!=null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public void close(){
        if(writer!=null){
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
