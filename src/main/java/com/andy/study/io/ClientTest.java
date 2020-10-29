package com.andy.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @time: 2020/10/27 十月 20:51
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ClientTest {
    public static final int port = ServerSokectTest.DEFAULT_PORT;
    public static final String host = "localhost";
    public static final String quit = ServerSokectTest.QUIT;

    public static void main(String[] args) throws IOException {
        System.out.println("客户端准备开始连接 Start...");
        Socket socket = null;
        BufferedReader in  = null;
        BufferedWriter out = null;
        Scanner sc = null;

        try {
            socket =new Socket(host, port);
            System.out.println("客户端连接成功"+socket.getLocalSocketAddress()+" "+socket.getRemoteSocketAddress());
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sc  = new Scanner(System.in);
            System.out.println("请开始向服务器发送消息:");
            String s = null;
            while((s=sc.nextLine()) != null){
                out.write(s);
                out.newLine();
                out.flush();
                String s1 = in.readLine();
                System.out.println("服务端返回:"+s1);
                if(quit.equals(s)){
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("客户端异常:" + e.getMessage());
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
            if(sc!=null){
                sc.close();
            }
            if (socket != null) {
                try {
                    System.out.println("客户端"+socket.getLocalPort()+"关闭");
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("客户端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}
