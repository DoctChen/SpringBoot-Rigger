package com.springboot.rigger.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 用户实体demo
 * @title: User
 * @Author Star_Chen
 * @Date: 2021/12/24 8:59
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class Users implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * @Author: Star_Chen
     * @Description:
     * @NotNull： 验证对象是否不为null, 无法查检长度为0的字符串
     * @NotBlank： 检查约束 (字符串) 是不是Null还有被Trim的长度是否大于0，只对字符串,且会去掉前后空格
     * @NotEmpty： 检查(集合)约束元素是否为NULL或者是EMPTY
     */
    @NotEmpty(message = "姓名不能为空哦！")
    private String name;

    private Integer orderId;

    private String address;
}
