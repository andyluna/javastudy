package com.liyi.service;

import com.liyi.dao.BookDao;
import com.liyi.dao.OrderDao;
import com.liyi.dao.OrderItemDao;
import com.liyi.dao.impl.BookDaoImpl;
import com.liyi.dao.impl.OrderImpl;
import com.liyi.dao.impl.OrderItemDaoImpl;
import com.liyi.pojo.Book;
import com.liyi.pojo.Cart;
import com.liyi.pojo.CartItem;
import com.liyi.pojo.Order;
import com.liyi.pojo.OrderItem;

import java.util.Date;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 17:21  星期五
 */
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao=new OrderImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    //保存订单
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号（唯一）
        String orderId=System.currentTimeMillis()+""+userId;
        //创建订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem=entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book=bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);



        }
        //清空购物车
        cart.clear();

        return orderId;
    }
}
