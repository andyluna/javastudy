package com.study.cms.manager.service.impl;

import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.dao.impl.UserDaoImpl;
import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;

/**
 * @time: 2021/6/16 六月 10:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();


    @Override
    public User findUserByUserName(String username) {
        User user = userDao.queryByUsername(username);
        return user;
    }
}
