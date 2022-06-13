package com.xym.springcloud.constant;

/**
 * @Description: 保存RabbitMQ相关常量信息
 * @author: xuym
 * @date: 2022/5/17 14:58
 * @version: V1.0
 */
public class RabbitMQConstant {
    /*
        交换价名
     */
    public static final String EXCHANGE_TOPIC_NAME = "exchange_topic_inform";
    public static final String EXCHANGE_FANOUT_NAME = "exchange_fanout";
    /*
        队列名
     */
    public static final String SIMPLE_QUEUE_NAME = "simple_queue";
    public static final String CONVERT_QUEUE_NAME = "convert_queue";
    public static final String ANNOTATION_BINDING_QUEUE_NAME = "annotation-binding";

    /*
        RoutingKey
     */
    public static final String SIMPLE_QUEUE_ROUTINGKEY = "#.simple.#";
    public static final String CONVERT_QUEUE_ROUTINGKEY = "#.convert.#";
}
