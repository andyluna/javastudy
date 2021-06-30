package com.study.cms.manager.dao.impl.hibernate;

import com.study.cms.comm.utils.HibernateUtil;
import com.study.cms.comm.utils.StringUtils;
import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.dao.UserDao;
import com.study.cms.manager.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * @time: 2021/6/30 六月 15:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserDaoHibernateImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoHibernateImpl.class);
    private DeptDao deptDao = new DeptHibernateDaoImpl();
    /**
     * 根据用户名查询单个用户
     *
     * @param username
     * @return
     */
    @Override
    public User queryByUsername(String username) {
        Session session = null;
        User u = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            String hql = "select u from User u where username=:username";
            u = (User) session.createQuery(hql)
                    .setParameter("username",username)
                    .getSingleResult();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return u;
    }

    @Override
    public User queryByUsername(Integer id, String username) {
        Session session = null;
        User u = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            String hql = "select u from User u where id=:id and username=:username ";
            u = (User) session.createQuery(hql)
                    .setParameter("id",id)
                    .setParameter("username",username)
                    .getSingleResult();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return u;
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
        Session session = null;
        User u = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            String hql = "select u from User u where username=:username and password=:password ";
            u = (User) session.createQuery(hql)
                    .setParameter("username",username)
                    .setParameter("password",password)
                    .getSingleResult();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return u;
    }

    /**
     * 根据id查找一个用户
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        Session session = null;
        User u = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            u = session.get(User.class,id);
            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return u;
    }



    /**
     * 保存一个用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }

    /**
     * 删除一个用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteUserById(Integer id) {
        Session session = null;
        int  n = 0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            //1
            String hql = "delete from User where id=:id ";
            n = session.createQuery(hql)
                    .setParameter("id",id)
                    .executeUpdate();
//            //2
//            User u = session.get(User.class,id);
//            if(u!=null){
//                session.delete(u);
//            }


            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return n;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        Session session = null;
        int n = 0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return 1;
    }



    @Override
    public List<User> queryUsers(String username, String name, Integer sex, Integer curPage, Integer pageSize) {
        Session session = null;
        List<User> users = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            String hql = "select u from User u where 1=1 ";
            if(StringUtils.isNotEmpty(username)){
                hql+= " and username like :username ";
            }
            if(StringUtils.isNotEmpty(name)){
                hql+= " and name like :name ";
            }
            if(sex!=null && !Objects.equals(sex,2)){
                hql+= " and sex =:sex ";
            }

            Query query = session.createQuery(hql);

            if(StringUtils.isNotEmpty(username)){
                query.setParameter("username",username+"%");
            }
            if(StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if(sex!=null&& !Objects.equals(sex,2)){
                query.setParameter("sex",sex);
            }
            query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize);
            users  =  query.getResultList();
            if(users!=null &&users.size()>0){
                for (User myuser :users){
                    if (myuser.getDept_id()!=null){
                        myuser.setDept(deptDao.queryDeptById(myuser.getDept_id()));
                    }
                }
            }
            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return users;
    }

    @Override
    public int queryUsersTotal(String username, String name, Integer sex) {
        Session session = null;
        int n = 0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            String hql = "select count(u) from User u where 1=1 ";
            if(StringUtils.isNotEmpty(username)){
                hql+= " and username like :username ";
            }
            if(StringUtils.isNotEmpty(name)){
                hql+= " and name like :name ";
            }
            if(sex!=null&& !Objects.equals(sex,2)){
                hql+= " and sex =:sex ";
            }

            Query query = session.createQuery(hql);

            if(StringUtils.isNotEmpty(username)){
                query.setParameter("username",username+"%");
            }
            if(StringUtils.isNotEmpty(name)){
                query.setParameter("name",name+"%");
            }
            if(sex!=null&& !Objects.equals(sex,2)){
                query.setParameter("sex",sex);
            }

            Number result = (Number) query.getSingleResult();
            n = result.intValue();

            session.getTransaction().commit();
            HibernateUtil.close(session);
        }catch (Exception e){
            session.getTransaction().rollback();
            HibernateUtil.close(session);
        }
        return n;
    }
}
