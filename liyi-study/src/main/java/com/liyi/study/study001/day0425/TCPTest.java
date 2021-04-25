package com.liyi.study.study001.day0425;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 14:42  星期日
 */
public class TCPTest {

    @Test
    public void client() {
        Socket socket= null;
        OutputStream os = null;
        try {
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            os.write("傻逼".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket.isClosed()){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }


    @Test
    public void server() {
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        Socket socket = null;
        ServerSocket sr = null;
        try {
            sr = new ServerSocket(8899);

            socket = sr.accept();

            is = socket.getInputStream();

//        byte[] buffer=new byte[20];
//        int len;
//        while ((len=is.read(buffer))!=-1){
//            String str=new String(buffer,0,len);
//            System.out.println(str);
//        }

            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sr != null) {

                try {
                    sr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }







}
