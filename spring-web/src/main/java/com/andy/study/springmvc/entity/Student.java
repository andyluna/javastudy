package com.andy.study.springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @time: 2020/12/3 十二月 11:10
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private LocalDate localDate = LocalDate.now();
    private Date date = new Date();
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}
