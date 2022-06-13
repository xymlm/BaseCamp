package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: eureka集群7002主启动类
 * @author: xuym
 * @date: 2022/4/21 16:31
 * @version: V1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServiceApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication7002.class, args);
    }
}
