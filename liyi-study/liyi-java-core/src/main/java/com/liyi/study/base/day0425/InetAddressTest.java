package com.liyi.study.base.day0425;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 14:20  星期日
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1=InetAddress.getByName("192.168.10.14");
//            System.out.println(inet1);
            InetAddress inet2=InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3=InetAddress.getLocalHost();
            System.out.println(inet3);

            System.out.println(inet2.getHostName());

            System.out.println(inet2.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
