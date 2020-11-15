package org.apache.rocketmq.example.base;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @time: 2020/11/10 十一月 10:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AsyncConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer dmc = new DefaultMQPushConsumer("andy-group");
        dmc.setNamesrvAddr("localhost:9876");
        dmc.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        dmc.subscribe("mytopic", "tag2");
        dmc.setMessageModel(MessageModel.CLUSTERING);//负载均衡模式
        dmc.setMessageModel(MessageModel.BROADCASTING);//广播

        dmc.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("消息接收成功 总共"+msgs.size()+"条"+Thread.currentThread().getName());

                for(MessageExt msg:msgs){
                    System.out.println(msg);
                    System.out.println("消息内容 = "+new String(msg.getBody()));

                }
                System.out.println("context = "+context);


                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /*
         *  Launch the consumer instance.
         */
        dmc.start();

        System.out.printf("Consumer Started.%n");
    }
}
