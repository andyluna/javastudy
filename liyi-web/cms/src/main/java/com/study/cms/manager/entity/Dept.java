package com.study.cms.manager.entity;

import com.study.cms.comm.anno.MyColumn;
import com.study.cms.comm.anno.MyId;
import com.study.cms.comm.anno.MyTableName;
import com.study.cms.comm.anno.MyTransient;
import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 10:35  星期六
 */
@Entity
@Table(name = "c_dept")
@MyTableName(value = "c_dept")
public class Dept {
    @MyId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    @MyColumn("parent_code")
    @Column(name = "parent_code")
    private String parentCode;

    @MyColumn("create_date")
    @Column(name = "create_date")
    private Date createDate;

    @MyColumn("last_update_date")
    @Column(name = "last_update_date")
    private Date lastUpdateDate;


    @MyTransient
    @Transient
    private String outher;

    @MyTransient
    @Transient
    private String outher1;

    @MyTransient
    @Transient
    private String outher2;





    public Dept() {
    }

    public Dept(Integer id, String name, String code, String parentCode, Date createDate, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentCode = parentCode;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
