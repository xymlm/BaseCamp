package com.xym.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 支付模块主启动类
 * @author: xuym
 * @date: 2022/4/20 16:14
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xym.springcloud.mapper")
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class, args);
    }
}
