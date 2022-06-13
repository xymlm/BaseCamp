package com.xym.config;

import com.xym.springcloud.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: RabbitMQ配置类
 * @author: xuym
 * @date: 2022/5/17 14:53
 * @version: V1.0
 */
@Configuration
public class RabbitMQConfig {

    /**
     * @Title: exchange
     * @Description: 注入主题Exchange
     * @author: xuym
     * @date: 2022/5/17 13:56
     * @throws
     */
    @Bean(RabbitMQConstant.EXCHANGE_TOPIC_NAME)
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(RabbitMQConstant.EXCHANGE_TOPIC_NAME).durable(true).build();
    }

    @Bean(RabbitMQConstant.SIMPLE_QUEUE_NAME)
    public Queue simpleQueue(){
        return new Queue(RabbitMQConstant.SIMPLE_QUEUE_NAME);
    }

    @Bean(RabbitMQConstant.CONVERT_QUEUE_NAME)
    public Queue convertQueue(){
        return new Queue(RabbitMQConstant.CONVERT_QUEUE_NAME);
    }

    @Bean
    public Binding topicSimpleBinding(@Qualifier(RabbitMQConstant.SIMPLE_QUEUE_NAME) Queue queue,
                                     @Qualifier(RabbitMQConstant.EXCHANGE_TOPIC_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.SIMPLE_QUEUE_ROUTINGKEY).noargs();
    }

    @Bean
    public Binding topicConvertBinding(@Qualifier(RabbitMQConstant.CONVERT_QUEUE_NAME) Queue queue,
                                        @Qualifier(RabbitMQConstant.EXCHANGE_TOPIC_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.CONVERT_QUEUE_ROUTINGKEY).noargs();
    }
}
