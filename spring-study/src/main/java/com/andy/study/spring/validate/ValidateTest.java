package com.andy.study.spring.validate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;

/**
 * @time: 2020/11/24 十一月 17:26
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class ValidateTest {

    @Test
    public void test1() {
        Person p = new Person();

        PersonValidator pv = new PersonValidator();
        BeanPropertyBindingResult res = new BeanPropertyBindingResult(p, "person");
        pv.validate(p, res);

        log.debug("是否有错误:{}", res.hasErrors());
    }
}
