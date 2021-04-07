package com.andy.study.boot.mapper;

import com.andy.study.boot.MyBatisPlusApplicationTest;
import com.andy.study.boot.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @time: 2021/2/1 二月 09:02
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserMapperTest extends MyBatisPlusApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        log.debug("userMapper:{}", userMapper);
    }


    @Test
    public void test2(){
        List<User> users = userMapper.selectList(null);
        users.forEach(u->log.debug("users:{}", u));
    }
}