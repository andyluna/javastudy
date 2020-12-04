package com.andy.study.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @time: 2020/12/3 十二月 11:10
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Student {
    private Integer id;
    private String name;
    private ZoneId zoneId = ZoneId.systemDefault();
    private ZoneId zoneId1;
    private Instant instant = Instant.now();
    private Instant instant1;
    private Duration duration = Duration.ZERO;
    private Duration duration1;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private LocalDateTime localDateTime1;
    private LocalDate localDate = LocalDate.now();
    private LocalDate localDate1;
    private LocalTime localTime = LocalTime.now();
    private LocalTime localTime1 ;
    private Date date = new Date();
    private Date date1;
    private java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
    private java.sql.Date sqlDate1;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private Timestamp timestamp1;
}
