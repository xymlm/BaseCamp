package com.xym.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.nio.charset.StandardCharsets;

/**
 * @Description: phone-queue队列消费具体执行逻辑
 * @author: xuym
 * @date: 2022/5/31 16:37
 * @version: V1.0
 */
@Slf4j
public class SimpleQueueListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info("从simple_queue读取到信息");
        // 消息转换 byte[] -> String
        String content = new String(message.getBody(), StandardCharsets.UTF_8);
        // 接受到消息message
        log.info("=============="+ content +"==============");

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
