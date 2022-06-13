package com.xym.listener;

import com.xym.springcloud.entity.CarEntity;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 指定监听器委托处理方法
 * @author: xuym
 * @date: 2022/6/2 13:27
 * @version: V1.0
 */
@Slf4j
public class MessageDelegate {

    /**
     * @throws
     * @Title: consumeImageMessage
     * @Description: 图片信息处理方法
     * @author: xuym
     * @date: 2022/6/2 13:29
     */
    public void consumeMessage(File file) {
        log.info("File :: " + file.toString());
    }

    /**
     * @throws
     * @Title: consumeJsonMessage
     * @Description: Json信息委托处理方法
     * @author: xuym
     * @date: 2022/6/2 14:11
     */
    public void consumeMessage(Map messageBody) {
        Map<String, String> map = new HashMap<>();
        for (Object key : messageBody.keySet()) {
            log.info(key + " :: " + messageBody.get(key));
        }
    }
}
