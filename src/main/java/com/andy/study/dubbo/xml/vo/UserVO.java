package com.andy.study.dubbo.xml.vo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @time: 2020/11/4 十一月 21:52
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class UserVO {
    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime birth;

    public UserVO(){

    }
    public UserVO(Integer id, String name, Integer age, LocalDateTime birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) &&
                Objects.equals(name, userVO.name) &&
                Objects.equals(age, userVO.age) &&
                Objects.equals(birth, userVO.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, birth);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
