package com.study.liyi.mybatis.dao;

import com.study.liyi.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/29 11:21  星期二
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}
