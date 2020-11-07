package com.andy.study.dubbo.javaapi.impl;

import com.andy.study.dubbo.xml.service.HelloService;
import com.andy.study.dubbo.xml.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @time: 2020/11/6 十一月 20:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class HelloServiceJavaApiImpl implements HelloService {
    private Map<Integer,UserVO> users = new HashMap<>();
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    @Override
    public String sayHello(String name) {
        log.debug("这是javaAPI参数name={}",name);
        return "这是javaAPI你好"+name;
    }

    @Override
    public LocalDateTime now() {
        log.debug("这是javaAPI");
        return LocalDateTime.now();
    }

    @Override
    public UserVO saveUser(String name, Integer age) {
        int id = atomicInteger.getAndIncrement();
        UserVO user = new UserVO(id, name, age, LocalDateTime.now());
        users.put(id,user);
        log.debug("这是javaAPI保存用户成功{}",user);
        return user;
    }

    @Override
    public UserVO getUserVOById(Integer id) {
        UserVO user = users.get(id);
        log.debug("这是javaAPIuser:{}",user);
        return user;
    }

    @Override
    public List<UserVO> getAllUsers() {
        ArrayList<UserVO> vos = new ArrayList<>(users.values());
        log.debug("这是javaAPI获取所有用户:{}",vos);
        return vos;
    }
}
