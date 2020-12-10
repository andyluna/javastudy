package com.andy.study.boot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @time: 2020/12/10 十二月 10:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Entity
@Table(name = "T_BOOT_PEOPLE3")
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private LocalDateTime createLocalDateTime;
    private LocalDate createLocalDate;
    private Date createDate;


}
