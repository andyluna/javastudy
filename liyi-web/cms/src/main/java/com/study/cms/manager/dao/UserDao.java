package com.study.cms.manager.dao;

import com.study.cms.manager.entity.User;

import java.util.List;

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


    public User queryByUsername(Integer id,String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryByUsernameAndPassword(String username,String password);


    /**
     * 根据id查找一个用户
     * @param id
     * @return
     */
    public User queryUserById(Integer id);





    /**
     * 保存一个用户
     * @param user
     * @return
     */
    public int addUser(User user);


    /**
     * 删除一个用户
     * @param id
     * @return
     */
    public int deleteUserById(Integer id);


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);


    List<User> queryUsers(String username, String name, Integer sex,Integer curPage,Integer pageSize);

    int queryUsersTotal(String username,String name,Integer sex);
}
