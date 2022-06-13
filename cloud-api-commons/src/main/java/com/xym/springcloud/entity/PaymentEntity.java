package com.xym.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @Description: 支付实体类
 * @author: xuym
 * @date: 2022/4/20 16:27
 * @version: V1.0
 */
@Data
@TableName(value = "payment")
public class PaymentEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;
}
