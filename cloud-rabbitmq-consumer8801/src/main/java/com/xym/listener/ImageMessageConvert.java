package com.xym.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @Description: 图片消息转换类
 * @author: xuym
 * @date: 2022/6/1 14:15
 * @version: V1.0
 */
@Slf4j
public class ImageMessageConvert implements MessageConverter {

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        return null;
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        log.info("接收到消息！！！");
        Object _extName = message.getMessageProperties().getHeaders().get("extName");
        String extName = _extName == null ? "jpg" : _extName.toString();
        byte[] body = message.getBody();
        String fileName = UUID.randomUUID().toString().replaceAll("-","");
        String path = "D:/data/rabbitMQ/" + fileName + "." + extName;
        File f = new File(path);
        try {
            Files.copy(new ByteArrayInputStream(body), f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

}
