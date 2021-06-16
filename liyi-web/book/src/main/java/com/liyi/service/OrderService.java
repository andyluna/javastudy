package com.liyi.service;

import com.liyi.pojo.Cart;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 17:20  星期五
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
