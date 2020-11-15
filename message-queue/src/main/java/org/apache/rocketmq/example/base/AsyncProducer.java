package org.apache.rocketmq.example.base;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @time: 2020/11/10 十一月 10:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //1.创建消费生产者
        DefaultMQProducer producer = new DefaultMQProducer("andy-group");
        //2.连接namesever
        producer.setNamesrvAddr("localhost:9876");
        //3.启动消费生产者
        producer.start();

        for (int i=0 ;i<10 ;i++){
            Message message = new Message();
            /**
             * topic 消息主题
             * tag   消息tag
             */
            message.setTopic("mytopic");
            message.setTags("tag2");
            message.setBody(("你好向丹helloworld"+i).getBytes());

            //异步消息
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送成功"+sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println("发送失败"+e);
                }
            });



            TimeUnit.SECONDS.sleep(1);
        }


        /*
         * Shut down once the producer instance is not longer in use.
         */
        producer.shutdown();
    }
}
