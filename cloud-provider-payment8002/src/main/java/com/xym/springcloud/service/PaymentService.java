package com.xym.springcloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xym.springcloud.entity.PaymentEntity;
import com.xym.springcloud.page.MyPage;

/**
 * @Description: 支付实体 service层操作接口
 * @author: xuym
 * @date: 2022/4/20 16:59
 * @version: V1.0
 */
public interface PaymentService extends IService<PaymentEntity> {

    IPage<PaymentEntity> page(MyPage<PaymentEntity> myPage);

}
