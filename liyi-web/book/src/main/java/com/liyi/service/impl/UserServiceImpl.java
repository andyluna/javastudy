package com.liyi.service.impl;

import com.liyi.dao.UserDao;
import com.liyi.dao.impl.UserDaoImpl;
import com.liyi.pojo.User;
import com.liyi.service.UserService;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/17 16:49  星期一
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.savaUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //==null说明没查到，可用
            return false;
        }

        return true;
    }
}
