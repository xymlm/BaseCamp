package com.xym;

import com.xym.springcloud.constant.RabbitMQConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 测试生产者主题模式发送消息
 * @author: xuym
 * @date: 2022/5/17 14:23
 * @version: V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicProducerSendTest {

    public static final List<String> MESSAGES = Arrays.asList("hello", "i", "am", "curry");

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        for(String str : MESSAGES){
            rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_TOPIC_NAME, "com.phone", str);
        }

    }
}
