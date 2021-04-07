package com.andy.study.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @time: 2021/1/19 一月 16:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Data
@TableName("USER")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String address;

    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField("field_type")
    private String fieldType;
}
