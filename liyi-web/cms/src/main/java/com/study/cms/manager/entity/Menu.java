package com.study.cms.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/21 15:34  星期一
 */
@Entity
@Table(name = "c_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;//菜单名
    private String url;//菜单路径
    @Column(name="open_type")
    private String openType;//菜单打开类型
    @Column(name="parent_id")
    private String parentId;//父菜单ID
    @Column(name="create_date")
    private Date createDate;//创建时间
    @Column(name="last_update_date")
    private Date lastUpdateDate;//最后一次修改时间

    public Menu() {
    }

    public Menu(Integer id, String name, String url, String openType, String parentId, Date createDate, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.openType = openType;
        this.parentId = parentId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", openType='" + openType + '\'' +
                ", parentId=" + parentId +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
