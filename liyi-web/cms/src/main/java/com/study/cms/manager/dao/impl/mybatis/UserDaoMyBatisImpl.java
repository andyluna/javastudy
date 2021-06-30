package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @time: 2021/6/30 六月 15:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserDaoMyBatisImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoMyBatisImpl.class);
    /**
     * 根据用户名查询单个用户
     *
     * @param username
     * @return
     */
    @Override
    public User queryByUsername(String username) {
        return null;
    }

    @Override
    public User queryByUsername(Integer id, String username) {
        return null;
    }

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        return null;
    }

    /**
     * 根据id查找一个用户
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        return null;
    }

    @Override
    public List userList() {
        return null;
    }

    /**
     * 保存一个用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public List<User> queryUsers(String username, String user, String sex) {
        return null;
    }

    @Override
    public List<User> queryUsers(String username, String user, String sex, Integer curPage, Integer pageSize) {
        return null;
    }

    @Override
    public int queryUsersTotal(String username, String user, String sex) {
        return 0;
    }
}
