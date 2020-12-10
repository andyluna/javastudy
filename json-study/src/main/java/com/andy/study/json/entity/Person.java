package com.andy.study.json.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @time: 2020/12/3 十二月 14:11
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private Integer id;
    private String name;
    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private LocalDateTime localDateTime1;
    private Date date;
    private Timestamp timestamp;
    private String sfzh;
    private String address;
    private List<String> list;
    private int[] array;
    private Map<String,Object> map;

    //private Stream intStream;


    public static Person createDefaultPerson(){
        return new Person(1,"向丹",LocalDate.now(),
                LocalDateTime.now(),null,
                new Date(),new Timestamp(System.currentTimeMillis()),"",null,
                Arrays.asList("1","2","3"),new int[]{3,4,5},
                Collections.singletonMap("key","张三")
                );
    }


}
