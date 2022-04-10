package com.springboot.rigger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.springboot.rigger.modules.dao"})
public class SpringbootRiggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRiggerApplication.class, args);
    }

}
