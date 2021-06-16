package com.study.cms.manager.dao;

import com.study.cms.manager.entity.User;

/**
 * @time: 2021/6/16 六月 10:56
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface UserDao {

    /**
     * 根据用户名查询单个用户
     * @param username
     * @return
     */
    public User queryByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryByUsernameAndPassword(String username,String password);


    /**
     * 保存一个用户
     * @param user
     * @return
     */
    public int addUser(User user);
}
