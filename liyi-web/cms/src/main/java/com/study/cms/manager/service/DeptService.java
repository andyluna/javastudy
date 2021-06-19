package com.study.cms.manager.service;

import com.study.cms.comm.vo.PageRes;
import com.study.cms.manager.entity.Dept;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 22:48  星期六
 */
public interface DeptService {

    PageRes queryDeptsPage(String name, String code, String parentCode, Integer curPage, Integer pageSize);


    void deleteDeptById(int id);

    Dept queryDeptById(int id);
}
