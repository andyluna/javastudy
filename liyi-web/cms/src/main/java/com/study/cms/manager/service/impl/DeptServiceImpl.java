package com.study.cms.manager.service.impl;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.dao.DeptDao;
import com.study.cms.manager.dao.impl.jdbc.DeptDaoImpl;
import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.study.cms.comm.utils.Constants.DEFAULT_PAGESIZE;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 22:48  星期六
 */
public class DeptServiceImpl implements DeptService {
    public static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    private DeptDao deptDao = new DeptDaoImpl();

    @Override
    public PageRes queryDeptsPage(String name, String code, String parentCode, Integer curPage, Integer pageSize) {
        //1.根据参数查询数据库记录的总数
        int total = deptDao.queryDeptTotal(name, code, parentCode);


        //2.计算总共有多少页
        int totalPage = total%pageSize==0?total/pageSize:+total/pageSize+1;

        curPage = curPage<1?curPage=1:curPage;//如果小于1 强制等于1
        curPage = curPage>totalPage?totalPage:curPage;//如果大于最大页 则等于最大页
        pageSize = pageSize<1?DEFAULT_PAGESIZE:pageSize;

        // 总共有多少条数据
        // 总共有多少页
        // 当前展示的是第几页
        // 当前页的真实数据
        List list = deptDao.queryDeptList(name, code, parentCode,curPage,pageSize);

        PageRes pageRes = new PageRes();
        pageRes.setTotal(total);
        pageRes.setTotalPage(totalPage);
        pageRes.setCurPage(curPage);
        pageRes.setPageSize(pageSize);
        pageRes.setData(list);

        return pageRes;
    }

    @Override
    public void deleteDeptById(int id) {
        deptDao.deleteDept(id);
    }

    @Override
    public Dept queryDeptById(int id) {
        Dept dept = deptDao.queryDeptById(id);
        return dept;
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }
}
