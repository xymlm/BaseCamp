package com.xym.springcloud.page;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 分页操作入参对象
 * @author: xuym
 * @date: 2022/4/20 19:35
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage<T> extends Page {

    private T filter;

}
