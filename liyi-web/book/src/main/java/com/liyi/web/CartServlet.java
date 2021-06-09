package com.liyi.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/9 19:58  星期三
 */
public class CartServlet extends BaseServlet{

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入了购物车");
//        System.out.println("商品编号："+req.getParameter("id"));
        //获取商品的编号

        //获取图书的信息

        //把图书信息转换成CartItem商品项

        //重定向到首页
    }
}
