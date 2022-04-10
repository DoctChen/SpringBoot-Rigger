package com.springboot.rigger.common.bean;

import com.springboot.rigger.modules.entity.Users;
import com.springboot.rigger.modules.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: Redis初始化数据demo，测试redis连通性
 * @title: RedisInitializingBean
 * @Author Star_Chen
 * @Date: 2022/4/9 21:55
 * @Version 1.0
 */
@Component
public class RedisInitializingBean {

    @Autowired
    private UserCacheService userCacheService;

    @PostConstruct
    public void init(){
        userCacheService.setUsers(new Users().setName("Michael").setAddress("China").setOrderId(001));
    }
}
