package com.study.cms.manager.entity;

import com.study.cms.comm.anno.MyId;
import com.study.cms.comm.anno.MyTableName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @time: 2021/6/16 六月 11:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@MyTableName(value="c_user")
@Entity
@Table(name = "c_user")
public class User {
    @MyId
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//存储的id
    private String username;//用户名
    private String password;//密码
    private String phone;//手机号
    private String name;//真实姓名
    private String address;//地址
    private Integer sex;//性别

    @Column(name = "dept_id")
    private Integer dept_id;//所属部门

    @Transient
    private Dept dept;


    public User() {
    }

    public User(Integer id, String username, String password, String phone, String name, String address, Integer sex, Integer dept_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.dept_id = dept_id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", dept_id=" + dept_id +
                '}';
    }
}
