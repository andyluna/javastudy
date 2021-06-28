package com.study.liyi.hibernate.entity.entity3;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/26 22:23  星期六
 */
public class Department3 {
    private Integer deptId;
    private String deptName;

    private Manager3 mgr;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Manager3 getMgr() {
        return mgr;
    }

    public void setMgr(Manager3 mgr) {
        this.mgr = mgr;
    }
}
