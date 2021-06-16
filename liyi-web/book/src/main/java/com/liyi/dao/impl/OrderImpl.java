package com.liyi.dao.impl;

import com.liyi.dao.OrderDao;
import com.liyi.pojo.Order;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 15:43  星期五
 */
public class OrderImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }
}
