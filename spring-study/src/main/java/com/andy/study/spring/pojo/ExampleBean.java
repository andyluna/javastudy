package com.andy.study.spring.pojo;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

/**
 * @time: 2020/11/20 十一月 20:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@ToString
public class ExampleBean {

    private AnotherBean anotherBean;

    private YetAnotherBean yetAnotherBean;

    private int i;

    private Car car;

    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExampleBean(AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i, String name) {
        this.anotherBean = anotherBean;
        this.yetAnotherBean = yetAnotherBean;
        this.i = i;
        this.name = name;
    }

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public YetAnotherBean getYetAnotherBean() {
        return yetAnotherBean;
    }

    public void setYetAnotherBean(YetAnotherBean yetAnotherBean) {
        this.yetAnotherBean = yetAnotherBean;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Car getCar() {
        return car;
    }

    @Required
     public void setCar(Car car) {
        this.car = car;
    }

}
