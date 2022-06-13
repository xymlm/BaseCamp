package com.xym.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 车实体类
 * @author: xuym
 * @date: 2022/6/2 10:29
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "car")
public class CarEntity {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long carId;

    /**
     * 颜色
     */
    private String color;

    /**
     * 品牌
     */
    private String brand;
}
