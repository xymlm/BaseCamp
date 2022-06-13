package com.xym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description: RabbitMQ生产者启动类
 * @author: xuym
 * @date: 2022/5/17 13:19
 * @version: V1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RabbitMQProducerApplication8800 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication8800.class, args);
    }
}
