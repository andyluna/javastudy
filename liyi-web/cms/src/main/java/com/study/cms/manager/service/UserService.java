package com.study.cms.manager.service;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.User;

import java.util.List;

/**
 * @time: 2021/6/16 六月 10:57
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface UserService {

    //根据用户名查找用户
    User findUserByUserName(String username);

    boolean existUserByUserName(String username);

    boolean existUserByUserName(Integer id,String username);

    //新增用户
    public void addUser(User user);

    //删除用户
    public void deleteUserById(Integer id);

    //修改用户信息
    public void updateUser(User user);

    //根据用户id查找用户
    public User queryUserById(Integer id);

    //查询所有用户保存到List集合中
    public List<User> queryUsers();

    List<User> queryUsers(String username,String user,String sex);





    PageRes queryUsersPage(String username, String user, String sex, Integer curPage, Integer pageSize);


}
