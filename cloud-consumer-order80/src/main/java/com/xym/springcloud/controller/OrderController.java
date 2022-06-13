package com.xym.springcloud.controller;

import com.xym.springcloud.entity.PaymentEntity;
import com.xym.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: 支付模块 controller层操作类
 * @author: xuym
 * @date: 2022/4/21 10:35
 * @version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public CommonResult save(@RequestBody PaymentEntity paymentEntity) {
        return restTemplate.postForObject(URL + "/payment/save", paymentEntity, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<PaymentEntity> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
    }

}
