package org.apache.rocketmq.example.base;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @time: 2020/11/10 十一月 09:42
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        //1.创建消费生产者
        DefaultMQProducer producer = new DefaultMQProducer("andy-group");
        //2.连接namesever
        producer.setNamesrvAddr("localhost:9876");
        //3.启动消费生产者
        producer.start();

        for (int i=0 ;i<10000 ;i++){
            Message message = new Message();
            /**
             * topic 消息主题
             * tag   消息tag
             */
            message.setTopic("mytopic");
            message.setTags("tag1");
            message.setBody(("你好向丹helloworld"+i).getBytes());
            //message.setDelayTimeLevel();

            SendResult send = producer.send(message);

            String id = send.getMsgId();//消息ID
            SendStatus status = send.getSendStatus();//发送状态
            int queueId = send.getMessageQueue().getQueueId();

//            System.out.println("消息ID"+id);
//            System.out.println("消息status"+status);
//            System.out.println("消息队列"+queueId);
            System.out.printf("%s%n", send);

            TimeUnit.SECONDS.sleep(1);
        }


        /*
         * Shut down once the producer instance is not longer in use.
         */
        producer.shutdown();
    }

}
