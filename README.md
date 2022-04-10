# springboot-rigger

#### 介绍

SpringBoot后端集成脚手架，喜欢可以直接拿去用。

#### 软件架构
后端脚手架可以直接在上面开发，技术点涉及Springboot+Mybatis+MybatisPlus+Redis分布式缓存


#### 技术选型
| 技术栈          | 版本            | 备注        |
|--------------|---------------|-----------|
| SpringBoot   | 2.1.9.RELEASE | 容器MVC框架   |
| Mybatis      | 3.5.9         | ORM框架     |
| Mybatis-Plus | 3.5.0         | Mybatis增强 |
| Redis        | 5.0           | 分布式缓存     |
| Lombok       | 1.18.10       | 对象封装工具    |
| Druid        | 1.1.16        | 数据库连接池    |


#### 项目包结构
``` lua
src
├── common -- 用于存放通用代码，包括异常Code定义
|   ├── bean -- 自定义业务Bean
|   ├── config -- 包括跨域、定义Spring配置类
|   ├── gen -- MyBatis-Plus代码生成器
├── dto -- 数据传输封装对象
├── enums-- 异常枚举类等业务枚举定义
├── exception -- 定义通用异常，业务异常拦截Bean
|-- modules -- 不同模块入口
   |   ├── controller -- 业务MVC入口
   |   ├── dao 数据传输层入口
   |   |—— entity -- 实体类入口
   |   |── service -- 业务逻辑入口
```

#### 资源文件说明

``` lua
resources
├── mapper -- MyBatis中mapper.xml存放位置
├── application.yml -- SpringBoot通用配置文件
├── application-dev.yml -- SpringBoot开发环境配置文件
├── application-prod.yml -- SpringBoot生产环境配置文件
└── generator.properties -- MyBatis-Plus代码生成器配置信息
```