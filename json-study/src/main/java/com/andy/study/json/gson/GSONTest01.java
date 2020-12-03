package com.andy.study.json.gson;

import com.andy.study.json.entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @time: 2020/12/3 十二月 14:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class GSONTest01 {
    private Person person;
    private Gson gson ;
    @Before
    public void before(){
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
        person = Person.createDefaultPerson();
        log.debug("person初始化成功:\n{}",person);
        builder = null;
    }
    @After
    public void after(){
        gson = null;
        person = null;
    }
    @Test
    public void test01(){
        String s = gson.toJson(person);
        log.debug("s=\n{}",s);
        Person person = gson.fromJson(s, Person.class);
        log.debug("person= \n{}",person);

    }

    @Test
    public void test02(){
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setPrettyPrinting()

                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeJsonSerializer())
                .registerTypeAdapter(LocalDate.class    ,new LocalDateJsonSerializer())
                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeJsonDerializer())
                .registerTypeAdapter(LocalDate.class    ,new LocalDateJsonDerializer())
                .serializeNulls()
                .create();
        String s = gson.toJson(person);
        log.debug("s=\n{}",s);
        Person person = gson.fromJson(s, Person.class);
        log.debug("person= \n{}",person);

    }
}
