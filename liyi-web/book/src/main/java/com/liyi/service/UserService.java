package com.liyi.service;

import com.liyi.pojo.User;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/17 16:32  星期一
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null表示登录失败，返回有值表示登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回用户名false表示用户名可用
     */
    public boolean existsUsername(String username);
}
