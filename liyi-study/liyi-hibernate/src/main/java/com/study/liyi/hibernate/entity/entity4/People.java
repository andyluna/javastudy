package com.study.liyi.hibernate.entity.entity4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @time: 2021/6/28 六月 10:21
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Entity
@Table(name="T_PEOPLE")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键

    @Column(name="name",length = 255)
    private String name;//姓名

    //@Column(name="sfzh",length = 255)
    //这个注解 注释也是可以的  默认所有字段会自动带上Column
    private String sfzh;//身份证号

    @Temporal(TemporalType.DATE)//告诉hibernate 这个字段 对应的额数据库  只需要存日期即可
    private Date birthDay;//生日

    private String address;//地址

    @Column(name = "create_id")
    private Integer createId;//创建人

    @Temporal(TemporalType.TIMESTAMP)//告诉hibernate 这个字段 对应的额数据库  即需要存日期又需要存时间
    @Column(name = "create_date")
    private Date createDate;//创建时间


    @Transient//这个注解 代表字段 不需要与数据库管理
    private String favor;//兴趣爱好


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

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", createId='" + createId + '\'' +
                ", createDate=" + createDate +
                ", favor='" + favor + '\'' +
                '}';
    }
}
