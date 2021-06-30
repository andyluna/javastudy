package com.study.cms.manager.dao.impl.mybatis;

import com.study.cms.comm.utils.MyBatisUtil;
import com.study.cms.manager.dao.MenuDao;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.Menu;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @time: 2021/6/30 六月 15:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MenuDaoMybatisImpl  implements MenuDao {
    private static final Logger log = LoggerFactory.getLogger(MenuDaoMybatisImpl.class);

    @Override
    public List<Menu> queryMenuList(String name, String openType, Integer parentId, Integer curPage, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name==null?null:name+"%");
        map.put("openType",openType==null?null:openType+"%");
        map.put("parentId",parentId==null?null:parentId+"%");

        map.put("firstPage",(curPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Menu> list = session.selectList("com.study.cms.manager.mapper.MenuMapper.queryMenuList", map);
        return list;

    }

    @Override
    public int queryMenuTotal(String name, String openType, Integer parentId) {
        SqlSession session = MyBatisUtil.getSession(true);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name==null?null:name+"%");
        map.put("openType",openType==null?null:openType+"%");
        map.put("parentId",parentId==null?null:parentId+"%");
        Integer total = session.selectOne("com.study.cms.manager.mapper.MenuMapper.queryMenuTotal", map);
        return total;

    }

    @Override
    public int deleteMenu(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.MenuMapper.deleteMenu",id);
    }

    @Override
    public int addMenu(Menu menu) {
        SqlSession session = MyBatisUtil.getSession(true);
        return session.insert("com.study.cms.manager.mapper.MenuMapper.addMenu",menu);
    }

    @Override
    public Menu queryMenuById(Integer id) {
        SqlSession session = MyBatisUtil.getSession(true);
        Menu menu = session.selectOne("com.study.cms.manager.mapper.MenuMapper.queryMenuById",id);
        return menu;
    }

    @Override
    public int updateMenu(Menu menu) {
        SqlSession session = MyBatisUtil.getSession(true);
        session.update("com.study.cms.manager.mapper.MenuMapper.updateMenu",menu);
        return 1;
    }
}
