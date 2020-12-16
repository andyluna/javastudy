package com.andy.study.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @time: 2020/11/28 十一月 15:33
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test01.xml"})
@Slf4j
public class MySpringTest {

    @Test
    public void test01() {
        log.debug("hello");
    }
}
