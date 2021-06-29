package com.study.cms.manager.mapper;

import com.study.cms.manager.entity.Dept;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 23:34  星期二
 */
public interface DeptMapper {

    List<Dept> selectAll(Dept dept);
}
