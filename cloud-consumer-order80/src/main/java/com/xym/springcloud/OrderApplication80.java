package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description: 订单模块主启动类
 * @author: xuym
 * @date: 2022/4/21 10:21
 * @version: V1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class, args);
    }
}
