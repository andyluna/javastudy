package com.andy.study.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @time: 2020/11/16 十一月 10:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ActiveMqConsumerTest01 {
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
        //6、使用会话对象创建消费者对象
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                // TODO Auto-generated method stub
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println("收到消息了 "+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        //8、程序等待接收用户消息
        System.in.read();
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();


    }


}
