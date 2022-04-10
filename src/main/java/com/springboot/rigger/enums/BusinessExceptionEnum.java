package com.springboot.rigger.enums;

import com.springboot.rigger.common.ErrorCode;
import lombok.Getter;

/**
 * @Description: 定义业务异常类枚举
 * @title: BusinessExceptionEnum
 * @Author Star_Chen
 * @Date: 2022/4/8 10:44
 * @Version 1.0
 */
@Getter
public enum BusinessExceptionEnum implements ErrorCode {

    // 业务异常从2开头
    CONFIG_NOT_EXIST(2001, "配置信息不存在"),

    VALIDATE_FAILED(2002, "参数检验失败"),

    DATA_IS_NOLL(2003, "数据返回为空"),

    PARAM_IS_NULL(2004, "参数为空");

    private Integer code;

    private String message;

    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
