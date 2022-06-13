package com.xym.listener;

import com.xym.springcloud.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @Description: 配置消息监听容器
 * @author: xuym
 * @date: 2022/5/31 16:46
 * @version: V1.0
 */
@Component
@Slf4j
public class MessageConsumerContainer {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean("simpleMessageContainer")
    public SimpleMessageListenerContainer simpleMessageTest(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(RabbitMQConstant.SIMPLE_QUEUE_NAME);
        //设置确认模式手工确认
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //消费者个数，线程个数
        container.setConcurrentConsumers(5);
        //设置预处理个数
        container.setPrefetchCount(1);
        //设置监听器，执行onMessage方法
        container.setMessageListener(new SimpleQueueListener());
        
        return container;
    }

    @Bean("convertMessageContainer")
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(RabbitMQConstant.CONVERT_QUEUE_NAME);
        //设置确认模式手工确认
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //消费者个数，线程个数
        container.setConcurrentConsumers(5);
        //设置预处理个数
        container.setPrefetchCount(1);

        MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
        // 方法委托 自定义方法
        adapter.setDefaultListenerMethod("consumeMessage");
        // 全局的转换器
        ContentTypeDelegatingMessageConverter convert = new ContentTypeDelegatingMessageConverter();

        // json转换器
        Jackson2JsonMessageConverter jsonConvert = new Jackson2JsonMessageConverter();
        convert.addDelegate("json", jsonConvert);
        convert.addDelegate("application/json", jsonConvert);

        // 图片转换器
        ImageMessageConvert imageConverter = new ImageMessageConvert();
        convert.addDelegate("image/jpg", imageConverter);
        convert.addDelegate("image", imageConverter);

        adapter.setMessageConverter(convert);
        container.setMessageListener(adapter);
        return container;
    }


}
