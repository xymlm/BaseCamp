package com.xym.springcloud.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xym.springcloud.entity.PaymentEntity;
import com.xym.springcloud.mapper.PaymentMapper;
import com.xym.springcloud.page.MyPage;
import com.xym.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @Description: 支付实对象service层操作实现类
 * @author: xuym
 * @date: 2022/4/20 17:01
 * @version: V1.0
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentEntity> implements PaymentService {

    /**
     * @throws
     * @Title: page
     * @Description: 根据查询条件过滤分页
     * @param:
     * @return:
     * @author: xuym
     * @date: 2022/4/20 19:47
     */
    @Override
    public IPage<PaymentEntity> page(MyPage<PaymentEntity> myPage) {
        // 过滤条件
        LambdaQueryWrapper<PaymentEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (myPage.getFilter().getSerial() != null) {
            queryWrapper.eq(PaymentEntity::getSerial, myPage.getFilter().getSerial());
        }

        // mapper层分页查询
        IPage<PaymentEntity> page = this.baseMapper.selectPage(myPage, queryWrapper);
        return page;
    }
}
