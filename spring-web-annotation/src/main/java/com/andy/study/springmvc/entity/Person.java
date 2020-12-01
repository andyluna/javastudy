package com.andy.study.springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @time: 2020/12/1 十二月 16:31
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;

    private String name;

    private Date date;

    private LocalDate localDate;

    private LocalDateTime localDateTime;


}
