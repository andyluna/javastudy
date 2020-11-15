package com.andy.study.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @time: 2020/11/15 十一月 14:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ActiveMqTest01 {
    public static void main(String[] args) {
        ActiveMQConnectionFactory acf = new ActiveMQConnectionFactory("failover://localhost:61616");
    }


}
