package com.andy.study.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @time: 2020/10/24 十月 11:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BCTest {

    public void test1() {

        try {
            InputStream in = new FileInputStream("abc.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            System.out.println("你好啊");
        }


    }

}
