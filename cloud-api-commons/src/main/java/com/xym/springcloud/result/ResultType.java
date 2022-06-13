package com.xym.springcloud.result;

/**
 * @Description: 接口返回状态枚举
 * @author: xuym
 * @date: 2022/4/21 10:34
 * @version: V1.0
 */
public enum ResultType {
    SUCCESS(200, "执行成功"),
    FAILED(201, "执行失败");

    private Integer code;
    private String message;

    ResultType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}