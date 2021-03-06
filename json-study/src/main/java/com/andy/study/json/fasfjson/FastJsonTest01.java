package com.andy.study.json.fasfjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.andy.study.json.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @time: 2020/12/3 十二月 14:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class FastJsonTest01 {
    private Person person;

    @Before
    public void before() {
        person = Person.createDefaultPerson();
        log.debug("person初始化成功:\n{}", person);
    }

    @After
    public void after() {
        person = null;
    }

    @Test
    public void test01() {
        String s = JSON.toJSONString(person, true);
        log.debug("s = \n{}", s);

        Person person = JSON.parseObject(s, Person.class);
        log.debug("p ={} \n{}", person.getClass(), person);
    }


    @Test
    public void test02() {
        String s = JSON.toJSONString(person,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteDateUseDateFormat);
        log.debug("s = \n{}", s);

        Person person = JSON.parseObject(s, Person.class);
        log.debug("p ={} \n{}", person.getClass(), person);
    }

    @Test
    public void test04() {
        SerializeConfig config = new SerializeConfig();
        SimpleDateFormatSerializer serializer = new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss");
        config.put(Date.class, serializer);

        String s = JSON.toJSONString(person, config,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteDateUseDateFormat);
        log.debug("s = \n{}", s);

        Person person = JSON.parseObject(s, Person.class);
        log.debug("p ={} \n{}", person.getClass(), person);
    }


}
