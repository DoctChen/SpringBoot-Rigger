package com.springboot.rigger.modules.service.impl;

import com.springboot.rigger.modules.dao.TestDao;
import com.springboot.rigger.modules.entity.Users;
import com.springboot.rigger.modules.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @title: TestServiceImpl
 * @Author Star_Chen
 * @Date: 2021/12/24 8:57
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Users> getUserList() {
        return testDao.getUserList();
    }
}
