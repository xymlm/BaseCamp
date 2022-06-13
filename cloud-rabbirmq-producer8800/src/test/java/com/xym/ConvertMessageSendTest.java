package com.xym;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xym.springcloud.constant.RabbitMQConstant;
import com.xym.springcloud.entity.CarEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description: 信息转换测试 - 发送端
 * @author: xuym
 * @date: 2022/6/1 14:39
 * @version: V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ConvertMessageSendTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendImageMessage() throws IOException {
        byte[] body = Files.readAllBytes(Paths.get("D:/", "test.jpg"));
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("image/jpg");
        messageProperties.getHeaders().put("extName", "jpg");
        Message message = new Message(body, messageProperties);
        rabbitTemplate.send(RabbitMQConstant.EXCHANGE_TOPIC_NAME, "com.convert", message);
    }

    @Test
    public void sendJsonMessage() throws JsonProcessingException {
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("奔驰");
        carEntity.setColor("蓝");

        // 设置参数
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");
        messageProperties.setContentType("json");

        String json = new ObjectMapper().writeValueAsString(carEntity);
        Message message = new Message(json.getBytes(), messageProperties);
        rabbitTemplate.send(RabbitMQConstant.EXCHANGE_TOPIC_NAME, "com.convert", message);
    }

}
