package com.springboot.rigger.modules.controller;

import com.springboot.rigger.modules.entity.Users;
import com.springboot.rigger.enums.BusinessExceptionEnum;
import com.springboot.rigger.exception.GlobalException;
import com.springboot.rigger.modules.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @title: TestController
 * @Author Star_Chen
 * @Date: 2021/12/23 10:55
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * @Date: 2021/12/24 9:05
     * @Author: Star_Chen
     * @Description: 测试接口demo
     * @Return: {@link null}
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET/*, consumes = "application/json"*/)
    public List<Users> test() {

        List<Users> userList = testService.getUserList();
        return userList;
    }

    /**
     * @Date: 2022/4/8 15:36
     * @Author: Star_Chen
     * @Param:  * @param null
     * @Description: 业务异常处理demo
     */
    @RequestMapping(value = "/testException", method = RequestMethod.GET/*, consumes = "application/json"*/)
    public List<Users> testException(String id) {

        if(StringUtils.isEmpty(id)){
            throw new GlobalException(BusinessExceptionEnum.CONFIG_NOT_EXIST);
        }

        List<Users> userList = testService.getUserList();
        if(userList.size() == 0 || userList == null){
            throw new GlobalException(BusinessExceptionEnum.DATA_IS_NOLL);
        }

        return userList;
    }


    /**
     * @Date: 2022/4/8 15:36
     * @Author: Star_Chen
     * @Param:  * @param null
     * @Description: 形参传递校验demo
     * 注意区分@Validated  和 @RequestBody
     */
    @RequestMapping(value = "/testValidated", method = RequestMethod.POST/*, consumes = "application/json"*/)
    public List<Users> testValidated(@Validated @RequestBody Users users) {

        if(StringUtils.isEmpty(users.getName())){
            throw new GlobalException(BusinessExceptionEnum.PARAM_IS_NULL);
        }

        List<Users> userList = testService.getUserList();
        if(userList.size() == 0 || userList == null){
            throw new GlobalException(BusinessExceptionEnum.DATA_IS_NOLL);
        }

        return userList;
    }
}
