package com.springboot.rigger.modules.dao;

import com.springboot.rigger.modules.entity.Users;

import java.util.List;

/**
 * @Description:
 * @title: TestDao
 * @Author Star_Chen
 * @Date: 2021/12/24 9:04
 * @Version 1.0
 */
public interface TestDao {

    /**
     * @Date: 2021/12/24 9:04
     * @Author: Star_Chen
     * @Param:  * @param null
     * @Description:
     * @Return: {@link null}
     */
    List<Users> getUserList();
}
