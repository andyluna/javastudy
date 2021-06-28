package com.study.liyi.hibernate.entity.entity3;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/26 22:24  星期六
 */
public class Manager3 {
    private Integer mgrId;
    private String mgrName;

    private Department3 dept;

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public Department3 getDept() {
        return dept;
    }

    public void setDept(Department3 dept) {
        this.dept = dept;
    }
}
