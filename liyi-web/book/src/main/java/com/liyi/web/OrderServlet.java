package com.liyi.web;

import com.liyi.pojo.Cart;

import com.liyi.pojo.User;
import com.liyi.service.OrderService;
import com.liyi.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/11 18:03  星期五
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService=new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        //获取Userid
        User loginUser= (User) req.getSession().getAttribute("user");

        //如果没有登录则跳转回登录页面
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userid = loginUser.getId();
        //调用orderService.createOrder(Cart,userId) 生成订单
        String orderId = orderService.createOrder(cart, userid);

        req.setAttribute("orderId",orderId);
        //请求转发订单结算页面
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

//        req.getSession().setAttribute("orderId",orderId);
//
//        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
