package com.study.cms.manager.service.impl;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.dao.impl.jdbc.UserDaoImpl;
import com.study.cms.manager.entity.User;
import com.study.cms.manager.service.UserService;

import java.util.List;

import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

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

    @Override
    public boolean existUserByUserName(String username) {
        if (userDao.queryByUsername(username)==null){
            return false;
        }
        return true;
    }
    @Override
    public boolean existUserByUserName(Integer id , String username) {
        boolean flag = false;
        if(id==null){//新增
            flag = userDao.queryByUsername(username) != null;
        }else{//修改
            flag = userDao.queryByUsername(id,username) != null;
        }
        return flag;
    }



    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);

    }

    @Override
    public List<User> queryUsers() {
        return userDao.userList();
    }


    @Override
    public List<User> queryUsers(String username,String name,String sex){
        List list = userDao.queryUsers(username, name, sex);
        return list;
    }



    @Override
    public PageRes queryUsersPage(String username,String name,String sex,Integer curPage,Integer pageSize){
        //1.根据参数查询数据库记录的总数
        int total = userDao.queryUsersTotal(username, name, sex);


        //2.计算总共有多少页
        int totalPage = total%pageSize==0?total/pageSize:+total/pageSize+1;

        curPage = curPage<1?curPage=1:curPage;//如果小于1 强制等于1
        curPage = curPage>totalPage?totalPage:curPage;//如果大于最大页 则等于最大页
        pageSize = pageSize<1?DEFAULT_PAGESIZE:pageSize;

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页
        // 当前页的真实数据
        List list = userDao.queryUsers(username, name, sex,curPage,pageSize);
        PageRes pageRes = new PageRes();
        pageRes.setTotal(total);
        pageRes.setTotalPage(totalPage);
        pageRes.setCurPage(curPage);
        pageRes.setPageSize(pageSize);
        pageRes.setData(list);

        return pageRes;
    }

}
