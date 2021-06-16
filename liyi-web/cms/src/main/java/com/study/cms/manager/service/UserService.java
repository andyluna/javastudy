package com.study.cms.manager.service;

import com.study.cms.manager.entity.User;

/**
 * @time: 2021/6/16 六月 10:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface UserService {

    //根据用户名查找用户
    User findUserByUserName(String username);


}
