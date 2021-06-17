package com.study.cms.manager.dao.impl;

import com.study.cms.comm.dao.BaseDao;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
    public User queryUserById(Integer id) {
        String sql="select * from c_user where id=?";
        return BaseDao.queryJavaBean(User.class,sql,id);
    }

    @Override
    public List userList() {
        String sql="select id,username,password,phone,name,address,sex,dept_id from c_user";
        return BaseDao.queryJavaBeanList(User.class,sql);
    }

    @Override
    public int addUser(User user) {
        String sql="insert into c_user(username,password,phone,name,address,sex,dept_id)values(?,?,?,?,?,?,?)";
        return BaseDao.update(sql,user.getUsername(),user.getPassword(),user.getPhone(),
                user.getName(),user.getAddress(),user.getSex(),user.getDept_id());
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql="delete from c_user where id=?";
        return BaseDao.update(sql,id);
    }

    @Override
    public int updateUser(User user) {
        String sql="update c_user set username=?,password=?,phone=?,name=?,address=?,sex=?,dept_id=? where id=?;";
        return BaseDao.update(sql,user.getUsername(),user.getPassword(),user.getPhone(),user.getName(),user.getAddress(),user.getSex(),user.getDept_id(),user.getId());
    }

    @Override
    public List<User> queryUsers(String username, String name, String sex) {
        StringBuilder sql= new StringBuilder("select id,username,password,phone,name,address,sex,dept_id from c_user where 1=1 ");
        List<String> list = new ArrayList<>();
        if(!StringUtils.isEmpty(username)){
            sql.append(" and username like ? ");
            list.add("%"+username.trim()+"%");
        }
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(sex) && !"2".equals(sex)){
            sql.append(" and sex = ? ");
            list.add(sex);
        }
        String[] param = list.toArray(new String[]{});

        List<User> users = BaseDao.queryJavaBeanList(User.class, sql.toString(),param);
        return  users;
    }

    @Override
    public List<User> queryUsers(String username, String name, String sex, Integer curPage, Integer pageSize) {
        StringBuilder sql= new StringBuilder("select id,username,password,phone,name,address,sex,dept_id from c_user where 1=1 ");
        List<Object> list = new ArrayList<>();
        if(!StringUtils.isEmpty(username)){
            sql.append(" and username like ? ");
            list.add("%"+username.trim()+"%");
        }
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(sex) && !"2".equals(sex)){
            sql.append(" and sex = ? ");
            list.add(sex);
        }
        sql.append(" limit ? , ? ");
        list.add((curPage-1)*pageSize);
        list.add(pageSize);
        // limit
        Object[] param = list.toArray(new Object[]{});

        List<User> users = BaseDao.queryJavaBeanList(User.class, sql.toString(),param);
        return  users;
    }


    @Override
    public int queryUsersTotal(String username, String name, String sex) {
        StringBuilder sql= new StringBuilder("select count(id) total from c_user where 1=1 ");
        List<String> list = new ArrayList<>();
        if(!StringUtils.isEmpty(username)){
            sql.append(" and username like ? ");
            list.add("%"+username.trim()+"%");
        }
        if(!StringUtils.isEmpty(name)){
            sql.append(" and name like ? ");
            list.add("%"+name.trim()+"%");
        }
        if(!StringUtils.isEmpty(sex) && !"2".equals(sex)){
            sql.append(" and sex = ? ");
            list.add(sex);
        }
        String[] param = list.toArray(new String[]{});
        MyTotal total = BaseDao.queryJavaBean(MyTotal.class, sql.toString(),param);
        return  total.getTotal();
    }

    public static class MyTotal{
        private Integer total;

        public MyTotal() {
        }

        public MyTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }

}
