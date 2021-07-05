package com.liyi.spring.spring5;

import java.util.Date;

/**
 * 作者
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/2 23:47  星期五
 */
public class Author {
    private String name;//姓名
    private Date birthDay;//生日
    private String sfzh;//身份证号

    public Author(String name, Date birthDay, String sfzh) {
        this.name = name;
        this.birthDay = birthDay;
        this.sfzh = sfzh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", sfzh='" + sfzh + '\'' +
                '}';
    }
}
