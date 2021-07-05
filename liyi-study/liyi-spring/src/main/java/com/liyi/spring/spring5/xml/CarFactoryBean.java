package com.liyi.spring.spring5.xml;

import com.liyi.spring.spring5.xml.entity.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 22:47  星期一
 */
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setId(3);
        car.setName("宝马");
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
