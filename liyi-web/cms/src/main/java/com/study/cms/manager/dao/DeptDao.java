package com.study.cms.manager.dao;

import com.study.cms.manager.entity.Dept;
import com.study.cms.manager.entity.User;

import java.util.List;


/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 21:35  星期六
 */
public interface DeptDao {
    /**
     * 根据name查询部门
     * @param name
     * @return
     */
    public Dept queryByName(String name);

    /**
     * 根据部门id和name查询部门
     * @param id
     * @param name
     * @return
     */
    public Dept queryByName(Integer id,String name);

    /**
     * 根据id查找一个部门
     * @param id
     * @return
     */
    public Dept queryDeptById(Integer id);

    /**
     * 根据部门编码查询部门
     * @param code
     * @return
     */
    public Dept queryDeptByCode(Integer code);

    /**
     * 查询所有部门
     * @return
     */
    public List DeptList();

    /**
     * 新增一个部门
     * @param dept
     * @return
     */
    public int addDept(Dept dept);

    /**
     * 删除一个部门
     * @param id
     * @return
     */
    public int deleteDept(Integer id);

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    public int updateDept(Dept dept);

    /**
     * 根据部门名称,部门编码,父部门编码查询部门
     * @param name
     * @param code
     * @param parentCode
     * @return
     */
    List<Dept> queryDeptList(String name, String code, String parentCode);


    List<Dept> queryDeptList(String name, String code, String parentCode,Integer curPage,Integer pageSize);


    int queryDeptTotal(String name, String code, String parentCode);


    List<Dept> queryAll();

}
