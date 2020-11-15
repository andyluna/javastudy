package com.andy.study.jvm.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/3 22:15  星期六
 */
public class DirectByteBufferTest2 {

    private static final int  BUFFER=  1024*1024*20;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int count = 0 ;
        try{
            while (true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
                list.add(byteBuffer);
                count++;
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            System.out.println(count);
        }


    }

}
