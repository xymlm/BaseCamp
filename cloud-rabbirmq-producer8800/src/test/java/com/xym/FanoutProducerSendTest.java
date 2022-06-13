package com.xym;

import com.xym.springcloud.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: fanout模式消息生产者
 * @author: xuym
 * @date: 2022/5/18 17:09
 * @version: V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class FanoutProducerSendTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        String msg = "注解绑定测试消息！！！";
        for(int i = 1 ; i <= 10 ; i++){
            rabbitTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_FANOUT_NAME,  "", msg + "消息序列号" + i);
        }

        log.info("消息发送成功！");
    }

}
