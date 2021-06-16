package com.liyi.dao;

import com.liyi.dao.impl.OrderImpl;
import com.liyi.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 16:46  星期五
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderImpl();
        orderDao.saveOrder(new Order("111",new Date(),new BigDecimal(100),0,1));
    }
}