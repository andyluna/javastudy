package com.andy.study.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @time: 2020/10/28 十月 21:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ChatClientInputHandler implements Runnable {
    private ChatClient chatClient;

    public ChatClientInputHandler(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while(true){
                line = br.readLine();

                chatClient.sendMessage(line);
                if(chatClient.readToQuit(line)){
                    break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
