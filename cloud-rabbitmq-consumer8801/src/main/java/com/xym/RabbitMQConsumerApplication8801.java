package com.xym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description: rabbitMQ消费者主启动类
 * @author: xuym
 * @date: 2022/5/17 15:05
 * @version: V1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RabbitMQConsumerApplication8801 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerApplication8801.class, args);
    }
}
