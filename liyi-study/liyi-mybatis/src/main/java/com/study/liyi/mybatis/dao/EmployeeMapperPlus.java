package com.study.liyi.mybatis.dao;

import com.study.liyi.mybatis.bean.Employee;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 20:32  星期二
 */
public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);
}
