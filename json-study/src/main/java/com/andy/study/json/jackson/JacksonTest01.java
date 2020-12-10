package com.andy.study.json.jackson;

import com.andy.study.json.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @time: 2020/12/3 十二月 14:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class JacksonTest01 {
    private ObjectMapper om;
    private Person person;
    @Before
    public void before(){
        om  = new ObjectMapper();
        person = Person.createDefaultPerson();
    }
    @After
    public void after(){
        om  = null;
        person = null;
    }
    @Test
    public void test01() throws Exception {
        String s = om.writeValueAsString(person);
        log.debug("s = \n{} ",s);
    }
    @Test
    public void test02() throws Exception {
        String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        //String s1 = om.writer(new DefaultPrettyPrinter()).writeValueAsString(person);
        log.debug("s = \n{} ",s);
    }

    @Test
    public void test03() throws Exception {
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.writerWithDefaultPrettyPrinter();
        String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        //String s1 = om.writer(new DefaultPrettyPrinter()).writeValueAsString(person);
        log.debug("s = \n{} ",s);
    }

    @Test
    public void test04() throws Exception {
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        om.writerWithDefaultPrettyPrinter();
        om.registerModule(javaTimeModule);
        String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        //String s1 = om.writer(new DefaultPrettyPrinter()).writeValueAsString(person);
        log.debug("s = \n{} ",s);

        Person person = om.readValue(s, Person.class);
        log.debug("person = \n{} ",person);
    }

    @Test
    public void test05() throws Exception {
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        om.writerWithDefaultPrettyPrinter();
        om.registerModule(javaTimeModule);


        Jdk8Module jdk8Module = new Jdk8Module();
        om.registerModule(jdk8Module);


        String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        //String s1 = om.writer(new DefaultPrettyPrinter()).writeValueAsString(person);

        log.debug("s = \n{} ",s);

        Person person = om.readValue(s, Person.class);
        log.debug("person = \n{} ",person);
    }
}
