package com.springboot.rigger.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.rigger.common.ErrorCode;
import com.springboot.rigger.enums.BusinessExceptionEnum;
import com.springboot.rigger.enums.CustomExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @title: CommonResult
 * @Author Star_Chen
 * @Date: 2021/12/24 9:16
 * @Version 1.0
 */
@JsonSerialize
@Data
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -3071263693733766212L;

    private Integer code;

    private String msg;

    private T data;

    protected CommonResult() {
    }

    protected CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static CommonResult newInstance() {
        return new CommonResult();
    }


    public CommonResult success() {
        return success(null);
    }

    public CommonResult success(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        return this;
    }
    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(ErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> CommonResult<T> failed(ErrorCode errorCode, String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 前端参数绑定错误异常
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(BusinessExceptionEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(BusinessExceptionEnum.VALIDATE_FAILED.getCode(), message, null);
    }


    public void buildReturnData(CustomExceptionEnum customExceptionEnum) {
        this.code = customExceptionEnum.getCode();
        this.msg = customExceptionEnum.getMsg();
    }
}
