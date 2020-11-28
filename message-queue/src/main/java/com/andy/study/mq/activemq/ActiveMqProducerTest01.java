package com.andy.study.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @time: 2020/11/15 十一月 14:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ActiveMqProducerTest01 {
    public static final String URL="tcp://localhost:61616";
    public static final String QUEQU_NAME="test-queue";

    public static void main(String[] args) throws Exception {
        //1、创建工厂连接对象，需要制定ip和端口号
        ActiveMQConnectionFactory acf = new ActiveMQConnectionFactory(URL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = acf.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue(QUEQU_NAME);
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);

        for(int i=0;i<5;i++){
            //7、使用会话对象创建一个消息对象
            TextMessage textMessage = session.createTextMessage("hello!test-queue你好啊222222222"+i);
            //8、发送消息
            producer.send(textMessage);
        }


        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }


}
