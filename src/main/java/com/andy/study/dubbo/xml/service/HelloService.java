package com.andy.study.dubbo.xml.service;

import com.andy.study.dubbo.xml.vo.UserVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @time: 2020/11/4 十一月 21:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface HelloService {

    String sayHello(String name);

    LocalDateTime now();

    UserVO saveUser(String name,Integer age);

    UserVO getUserVOById(Integer id);

    List<UserVO> getAllUsers();

}
