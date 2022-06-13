package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: enreka-service模块主启动类
 * @author: xuym
 * @date: 2022/4/21 14:39
 * @version: V1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServiceApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication7001.class, args);
    }
}
