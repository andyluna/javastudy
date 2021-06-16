package com.study.cms.manager.dao.impl;

import com.study.cms.comm.dao.BaseDao;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2021/6/16 六月 10:56
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserDaoImpl  implements UserDao{
    private final static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User queryByUsername(String username) {
        String sql="select id,username,password,phone from c_user where username=?";
        User user = BaseDao.queryJavaBean(User.class, sql, username);
        log.debug("根据用户名[{}]查询用户返回结果:{}",username,user);
        return user;
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,phone from c_user where username=? and password=?";
        return BaseDao.queryJavaBean(User.class,sql,username,password);
    }

    @Override
    public int addUser(User user) {
        String sql="insert into c_user(username,password,phone)values(?,?,?)";
        return BaseDao.update(sql,user.getUsername(),user.getPassword(),user.getPhone());
    }
}
