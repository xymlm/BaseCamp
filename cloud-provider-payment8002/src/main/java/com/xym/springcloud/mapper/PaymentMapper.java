package com.xym.springcloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xym.springcloud.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

/**
 * @Description: 支付实体 dao层操作接口
 * @author: xuym
 * @date: 2022/4/20 16:53
 * @version: V1.0
 */
@Repository
public interface PaymentMapper extends BaseMapper<PaymentEntity> {

}
