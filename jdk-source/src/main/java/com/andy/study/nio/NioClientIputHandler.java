package com.andy.study.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @time: 2020/10/29 十月 20:46
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class NioClientIputHandler implements Runnable {
    private NioChatClient nioChatClient;

    public NioClientIputHandler(NioChatClient nioChatClient) {
        this.nioChatClient = nioChatClient;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请开始聊天");
            String line = null;
            while (true) {
                line = br.readLine();

                nioChatClient.sendMessage(line);
                if (nioChatClient.readToQuit(line)) {
                    System.out.println("客户端退出");
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
