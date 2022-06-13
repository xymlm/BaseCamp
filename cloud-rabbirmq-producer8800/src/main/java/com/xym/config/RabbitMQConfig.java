package com.xym.config;

import com.xym.springcloud.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: RabbitMQ配置类
 * @author: xuym
 * @date: 2022/5/17 13:26
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

//    @Bean(RabbitMQConstant.EXCHANGE_FANOUT_NAME)
//    public Exchange fanoutExchange(){
//        return ExchangeBuilder.fanoutExchange(RabbitMQConstant.EXCHANGE_FANOUT_NAME).durable(true).build();
//    }


    @Bean(RabbitMQConstant.SIMPLE_QUEUE_NAME)
    public Queue phoneQueue(){
        return new Queue(RabbitMQConstant.SIMPLE_QUEUE_NAME);
    }

    @Bean(RabbitMQConstant.CONVERT_QUEUE_NAME)
    public Queue computerQueue(){
        return new Queue(RabbitMQConstant.CONVERT_QUEUE_NAME);
    }

//    @Bean(RabbitMQConstant.ANNOTATION_BINDING_QUEUE_NAME)
//    public Queue annotationBindingQueue(){
//        return new Queue(RabbitMQConstant.ANNOTATION_BINDING_QUEUE_NAME);
//    }


    @Bean
    public Binding topicPhoneBinding(@Qualifier(RabbitMQConstant.SIMPLE_QUEUE_NAME) Queue queue,
                                     @Qualifier(RabbitMQConstant.EXCHANGE_TOPIC_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.SIMPLE_QUEUE_ROUTINGKEY).noargs();
    }

    @Bean
    public Binding topicComputerBinding(@Qualifier(RabbitMQConstant.CONVERT_QUEUE_NAME) Queue queue,
                                     @Qualifier(RabbitMQConstant.EXCHANGE_TOPIC_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.CONVERT_QUEUE_ROUTINGKEY).noargs();
    }

//    @Bean
//    public Binding annotationBinding(@Qualifier(RabbitMQConstant.ANNOTATION_BINDING_QUEUE_NAME) Queue queue,
//                                        @Qualifier(RabbitMQConstant.EXCHANGE_FANOUT_NAME) Exchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
//    }
    
}
