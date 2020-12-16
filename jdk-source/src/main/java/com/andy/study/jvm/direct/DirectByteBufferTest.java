package com.andy.study.jvm.direct;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2020/10/3 21:40  星期六
 */
public class DirectByteBufferTest {

    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024 * 1024 * 1);


        System.out.println("直接内存分配完毕");

        Scanner sc = new Scanner(System.in);

        String next = sc.next();

        System.out.println("开始释放内存");


        bb = null;
        System.gc();

        sc.next();
    }
}
