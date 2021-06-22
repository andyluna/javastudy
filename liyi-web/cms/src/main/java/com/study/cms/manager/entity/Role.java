package com.study.cms.manager.entity;

import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/22 15:30  星期二
 */
public class Role {//角色

    private Integer id;
    private String code; //角色编码
    private String name; //角色名称
    private Date createDate; //创建时间
    private Integer createUserId; //创建人Id
    private Date lastUpdateDate; //最后修改时间
    private Integer lastUpdateId; //最后修改人Id

    public Role() {
    }

    public Role(Integer id, String code, String name, Date createDate, Integer createUserId, Date lastUpdateDate, Integer lastUpdateId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateId = lastUpdateId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Integer lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateId=" + lastUpdateId +
                '}';
    }
}
