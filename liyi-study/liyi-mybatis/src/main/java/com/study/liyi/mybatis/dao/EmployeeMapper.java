package com.study.liyi.mybatis.dao;

import com.study.liyi.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/28 22:17  星期一
 */
public interface EmployeeMapper {

    //返回多条记录的Map: Map<Integer,Employee>: 键是这条记录的主键,值是记录封装后的javaBean
    //@MapKey 告诉mybatis 封装这个Map的时候使用哪个属性作为Map的key
    @MapKey("id")
    public Map<Integer, Employee> getEmpsByIdReturnMap(String lastName);

    //返回一条记录的Map
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    public List<Employee> getEmpsByLastNameList(String lastname);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmpById(Integer id);

    public void updateEmp(Employee employee);

    public boolean addEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
