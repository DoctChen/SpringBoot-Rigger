package com.springboot.rigger.modules.service;


import com.springboot.rigger.modules.entity.Users;

/**
 * @Description:
 * @title: UserCacheService
 * @Author Star_Chen
 * @Date: 2022/4/9 21:45
 * @Version 1.0
 */
public interface UserCacheService {

    /**
     * 获取缓存后台用户信息
     */
    Users getUsers(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setUsers(Users users);
}
