package com.andy.study.spring.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/28 十一月 16:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private LocalDateTime birthDay;


}
