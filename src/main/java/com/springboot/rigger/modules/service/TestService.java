package com.springboot.rigger.modules.service;

import com.springboot.rigger.modules.entity.Users;
import java.util.List;

/**
 * @Description:
 * @title: TestService
 * @Author Star_Chen
 * @Date: 2021/12/24 8:57
 * @Version 1.0
 */
public interface TestService {

    /**
     * @Date: 2021/12/24 9:01
     * @Author: Star_Chen
     * @Param:  * @param null
     * @Description: 获取所有用户接口
     * @Return: List<User>
     */
    List<Users> getUserList();
}
