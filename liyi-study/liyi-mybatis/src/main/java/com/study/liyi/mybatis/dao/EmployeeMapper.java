package com.study.liyi.mybatis.dao;

import com.study.liyi.mybatis.bean.Employee;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/28 22:17  星期一
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
