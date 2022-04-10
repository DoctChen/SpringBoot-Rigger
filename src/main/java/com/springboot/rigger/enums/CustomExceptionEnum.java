package com.springboot.rigger.enums;

import lombok.Getter;

/**
 * @Description: 定义通用异常类枚举
 * @title: CustomExceptionEnum
 * @Author Star_Chen
 * @Date: 2021/12/24 9:39
 * @Version 1.0
 */
@Getter
public enum CustomExceptionEnum{

    SUCCESS(200, "success"),

    SYSTEM_EXCEPTION(1000, "system exception");

    private Integer code;

    private String msg;

    CustomExceptionEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
