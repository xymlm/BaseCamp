package com.xym.listener;

import com.rabbitmq.client.Channel;
import com.xym.springcloud.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange ;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.AbstractRabbitListenerContainerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description: 消费者处理器，监听队列消息
 * @author: xuym
 * @date: 2022/5/17 14:55
 * @version: V1.0
 */
@Component
@Slf4j
public class ReceiveHandler {

//    @RabbitListener(queues = {RabbitMQConstant.PHONE_QUEUE_NAME})
//    public void receivePhoneMsg(Message message, Channel channel){
//        System.out.println("phone queue receive message:" + message);
//        System.out.println("channel:" + channel);
//    }

//    @RabbitListener(queues = {RabbitMQConstant.COMPUTER_QUEUE_NAME})
//    public void receiveComputerMsg(Message message, Channel channel){
//        System.out.println("computer queue receive message:" + message);
//    }

    @RabbitListener(bindings = {
            @QueueBinding(
                value = @Queue(value = RabbitMQConstant.ANNOTATION_BINDING_QUEUE_NAME, durable = "true"),
                exchange = @Exchange(value = RabbitMQConstant.EXCHANGE_FANOUT_NAME, type = ExchangeTypes.FANOUT)
            )
    })
    public void receiveAnnotationBindingMsg(Message message, Channel channel){
        log.info("接受到消息:{}", message.toString());
        try {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
