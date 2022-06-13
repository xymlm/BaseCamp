package com.xym.springcloud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xym.springcloud.entity.PaymentEntity;
import com.xym.springcloud.page.MyPage;
import com.xym.springcloud.result.CommonResult;
import com.xym.springcloud.result.ResultType;
import com.xym.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 支付对象 controller层操作对象
 * @author: xuym
 * @date: 2022/4/20 17:11
 * @version: V1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * @Title: getById
     * @Description:  根据id查询
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 18:40
     * @throws
     */
    @GetMapping("/get/{id}")
    public CommonResult<PaymentEntity> getById(@PathVariable(value = "id") Long id) {
        PaymentEntity paymentEntity = paymentService.getById(id);
        if (paymentEntity == null) {
            return new CommonResult<>(ResultType.FAILED.getCode(), ResultType.FAILED.getMessage());
        } else {
            log.info("查询成功，端口号：" + servicePort);
            return new CommonResult<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage() + "  port:" + servicePort, paymentEntity);
        }
    }

    /**
     * @Title: save
     * @Description:  新增支付数据
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 18:40
     * @throws
     */
    @PostMapping("/save")
    public CommonResult save(@RequestBody PaymentEntity paymentEntity){
        boolean result = paymentService.save(paymentEntity);
        if (result) {
            log.info("保存成功，端口号：" + servicePort);
            return new CommonResult<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage() + "  port:" + servicePort);
        } else {
            return new CommonResult<>(ResultType.FAILED.getCode(), ResultType.FAILED.getMessage());
        }
    }

    /**
     * @Title: delete
     * @Description:  根据id删除
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 18:41
     * @throws
     */
    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        boolean result = paymentService.removeById(id);
        if (result) {
            return new CommonResult<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage());
        } else {
            return new CommonResult<>(ResultType.FAILED.getCode(), ResultType.FAILED.getMessage());
        }
    }

    /**
     * @Title: update
     * @Description:  更新
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 18:41
     * @throws
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody PaymentEntity paymentEntity){
        boolean result = paymentService.updateById(paymentEntity);
        if (result) {
            return new CommonResult<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage());
        } else {
            return new CommonResult<>(ResultType.FAILED.getCode(), ResultType.FAILED.getMessage());
        }
    }

    /**
     * @Title: page
     * @Description:  分页查询
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 19:46
     * @throws
     */
    @PostMapping("/page")
    public CommonResult<IPage<PaymentEntity>> page(@RequestBody MyPage<PaymentEntity> myPage){
        IPage<PaymentEntity> page = paymentService.page(myPage);
        return new CommonResult<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage(), page);
    }

    @GetMapping("/discovery")
    public CommonResult testDiscovery(){
        for(String service : discoveryClient.getServices()){
            log.info("serviceName:" + service);
            for(ServiceInstance instance : discoveryClient.getInstances(service)){
                log.info("\t" + instance.getInstanceId());
            }
        }
        return new CommonResult(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getMessage());
    }
}

