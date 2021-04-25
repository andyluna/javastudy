package com.liyi.study.study001.day0425;

import org.junit.Test;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 15:14  星期日
 */
public class TCPTest1 {

    @Test
    public void test1() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);

        OutputStream os=socket.getOutputStream();


        FileInputStream fis=new FileInputStream("穿越火线2.png");

        byte[] buffer=new byte[20];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);

        }

        fis.close();
        os.close();
        socket.close();

    }


    @Test
    public void test2() throws IOException{

        ServerSocket ss = new ServerSocket(9090);

        Socket socket=ss.accept();

        InputStream is=socket.getInputStream();


        FileOutputStream fos=new FileOutputStream("穿越火线121.png");

        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        socket.close();
        ss.close();


    }
}
