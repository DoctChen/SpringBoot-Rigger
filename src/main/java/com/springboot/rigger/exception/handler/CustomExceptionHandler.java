package com.springboot.rigger.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.springboot.rigger.dto.CommonResult;
import com.springboot.rigger.enums.CustomExceptionEnum;
import com.springboot.rigger.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description: 自定义拦截异常
 * @title: CustomExceptionHandler
 * @Author Star_Chen
 * @Date: 2021/12/24 9:10
 * @Version 1.0
 */
@ControllerAdvice(value = "com.springboot.rigger.modules.controller")
@Slf4j
public class CustomExceptionHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonResult commonResult = CommonResult.newInstance();
        commonResult.buildReturnData(CustomExceptionEnum.SUCCESS);
        commonResult.setData(o);
        if (o instanceof String) {
            return JSONObject.toJSONString(o);
        }
        return commonResult;
    }


    /**
     * @Date: 2021/12/24 15:45
     * @Author: Star_Chen
     * @Param: * @param null
     * @Description: 业务异常拦截后返回的Dto
     */
    @ExceptionHandler({GlobalException.class, Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonResult controllerHandler(Exception e) {
        CommonResult commonResult = CommonResult.newInstance();
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            commonResult.setCode(globalException.getCode());
            commonResult.setMsg(globalException.getMsg());
        } else {
            commonResult.buildReturnData(CustomExceptionEnum.SYSTEM_EXCEPTION);
        }
        log.error("doc compare system error, {}", e);
        return commonResult;
    }

    /**
     * @Date: 2022/4/9 20:51
     * @Author: Star_Chen
     * @Param: * @param null
     * @Description: 参数有效性校验拦截，通过@Validated进行校验
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(message);
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public CommonResult handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(message);
    }

}
