package com.study.liyi.mybatis.dao;

import com.study.liyi.mybatis.bean.Department;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 21:48  星期二
 */
public interface DepartmentMapper {

    public Department getDeptById(Integer id);
}
