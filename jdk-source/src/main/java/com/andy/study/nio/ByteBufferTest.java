package com.andy.study.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @time: 2020/10/29 十月 15:47
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        byte[] a = "abc".getBytes();
        System.out.println(Arrays.toString(a));


        ByteBuffer buff = ByteBuffer.allocate(10);
        buff.put(a);


        System.out.println(buff);
        System.out.println(buff.isReadOnly());
        System.out.println(buff.isDirect());

    }
}
