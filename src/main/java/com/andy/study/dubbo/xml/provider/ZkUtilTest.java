package com.andy.study.dubbo.xml.provider;

import org.springframework.util.SocketUtils;

/**
 * @time: 2020/11/6 十一月 19:51
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ZkUtilTest {
    public static void main(String[] args) {
        int availableTcpPort = SocketUtils.findAvailableTcpPort();
        System.out.println(availableTcpPort);
    }
}
