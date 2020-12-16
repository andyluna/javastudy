package com.andy.study.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @time: 2020/10/28 十月 21:22
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ChatHandler implements Runnable {

    private ChatServer server;
    private Socket socket;

    public ChatHandler(ChatServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader bi = null;
        try {
            //存储新上线用户
            server.addClient(socket);
            InputStream in;
            bi = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = bi.readLine()) != null) {
                String resmsg = "客户端[" + socket.getPort() + "]说:" + msg + "\n";
                System.out.print(resmsg);

                server.forwardMessage(socket, resmsg);

                if (server.readyToQuit(msg)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.removeSocket(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
