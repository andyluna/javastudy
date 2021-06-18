package com.liyi.dao.impl;

import com.liyi.dao.OrderItemDao;
import com.liyi.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 17:07  星期五
 */
public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100),"111"));
        orderItemDao.saveOrderItem(new OrderItem(null,"数据库精通",2,new BigDecimal(100),new BigDecimal(200),"111"));
        orderItemDao.saveOrderItem(new OrderItem(null,"C++基础",1,new BigDecimal(100),new BigDecimal(100),"111"));
        orderItemDao.saveOrderItem(new OrderItem(null,"JAVA基础",1,new BigDecimal(100),new BigDecimal(100),"111"));
    }
}