package com.springboot.rigger.modules.service.impl;

import com.springboot.rigger.common.bean.RedisBase;
import com.springboot.rigger.modules.entity.Users;
import com.springboot.rigger.modules.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户信息缓存demo
 * @title: UserCacheServiceImpl
 * @Author Star_Chen
 * @Date: 2022/4/9 21:45
 * @Version 1.0
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Value("${redis.db}")
    private String REDIS_DB;

    @Value("${redis.key.user}")
    private String REDIS_KEY_USER;

    @Value("${redis.key.resource}")
    private String REDIS_KEY_RESOURCE;

    @Value("${redis.expire.time}")
    private Long REDIS_EXPIRE_TIME;

    @Autowired
    private RedisBase redisBase;

    @Override
    public Users getUsers(String username) {
        String key = REDIS_DB + ":" + REDIS_KEY_USER + ":" + username;
        return (Users) redisBase.get(key);
    }

    @Override
    public void setUsers(Users users) {
        String key = REDIS_DB + ":" + REDIS_KEY_USER + ":" + users.getName();
        redisBase.set(key, users, REDIS_EXPIRE_TIME);
    }
}
