package com.liyi.web;

import com.google.gson.Gson;
import com.liyi.pojo.Book;
import com.liyi.pojo.Cart;
import com.liyi.pojo.CartItem;
import com.liyi.service.BookService;
import com.liyi.service.impl.BookServiceImpl;
import com.liyi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/9 19:58  星期三
 */
public class CartServlet extends BaseServlet{

    private BookService bookService=new BookServiceImpl();

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        int count=WebUtils.parseInt(req.getParameter("count"),1);
        //获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart!=null){
            //修改
            cart.updateCount(id,count);
            //回到购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");

        if (cart!=null){
            //清空
            cart.clear();
            //重定向回原来的购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品的编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //获取购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");

        if (cart!=null){
            //删除购物车商品项
            cart.deleteItems(id);
            //重定向回原来的购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));

        }
    }

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
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //获取图书的信息
        Book book=bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //获取购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");

        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //添加商品项
        cart.addItems(cartItem);

//        System.out.println(cart);
//        System.out.println("请求头的地址"+req.getHeader("Referer"));

        req.getSession().setAttribute("lastName",cartItem.getName());
        //重定向到请求头
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品的编号
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //获取图书的信息
        Book book=bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //获取购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");

        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //添加商品项
        cart.addItems(cartItem);

        //返回购物车总的商品数量和最后一个添加的商品名称
        Map<String, Object> resultMap=new HashMap<String,Object>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson=new Gson();
        String s=gson.toJson(resultMap);

        resp.getWriter().write(s);


    }

}
