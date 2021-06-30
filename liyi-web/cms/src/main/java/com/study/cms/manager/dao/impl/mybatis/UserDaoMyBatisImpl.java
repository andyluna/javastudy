package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.comm.utils.MyBatisUtil;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        SqlSession session = MyBatisUtil.getSession(true);
        User user = session.selectOne("com.study.cms.manager.mapper.UserMapper.queryByUsername2", username);
        return user;
    }

    @Override
    public User queryByUsername(Integer id, String username) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);
        map.put("username",username);
        User user = session.selectOne("com.study.cms.manager.mapper.UserMapper.queryByUsername1", map);
        return user;
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
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username",username);
        map.put("password",password);
        User user = session.selectOne("com.study.cms.manager.mapper.UserMapper.queryByUsernameAndPassword", map);
        return user;
    }

    /**
     * 根据id查找一个用户
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        User user = session.selectOne("com.study.cms.manager.mapper.UserMapper.queryUserById",id);
        return user;
    }



    /**
     * 保存一个用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.UserMapper.addUser",user);
    }

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteUserById(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.UserMapper.deleteUserById",id);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        SqlSession session = MyBatisUtil.getSession(true);
        session.update("com.study.cms.manager.mapper.UserMapper.updateUser",user);
        return 1;
    }


    @Override
    public List<User> queryUsers(String username, String name, Integer sex, Integer curPage, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username",username==null?null:username+"%");
        map.put("name",name==null?null:name+"%");
        map.put("sex",sex==null?null:sex+"%");

        map.put("firstPage",(curPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> userList = session.selectList("com.study.cms.manager.mapper.UserMapper.queryUsers", map);
        return userList;
    }

    @Override
    public int queryUsersTotal(String username, String name, Integer sex) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username",username==null?null:username+"%");
        map.put("name",name==null?null:name+"%");
        map.put("sex",sex==null?null:sex+"%");
        Integer total = session.selectOne("com.study.cms.manager.mapper.UserMapper.queryUsersTotal", map);
        return total;
    }
}
