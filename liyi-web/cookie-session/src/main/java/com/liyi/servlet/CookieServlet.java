package com.liyi.servlet;

import com.liyi.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/7 21:58  星期一
 */
public class CookieServlet extends BaseServlet{
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("dafalutLife", "defalutLife");
        //设置存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一
        //创建一个同名的Cookie对象
        //在构造器同时赋予新的Cookie值
//        Cookie cookie=new Cookie("key1", "newvalue1");
//        //通知客户端保存修改
//        resp.addCookie(cookie);
//        resp.getWriter().write("key1的值已经修改好了");

        //方案二
        //先查找到需要修改的cookie值
        Cookie cookie=CookieUtils.findCookie("key2",req.getCookies());
        if (cookie!=null){
            //调用setValue()方法赋予新的Cookie值
            cookie.setValue("newvalue2");
            //调用response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);
            resp.getWriter().write("key2的值已经修改好了");
        }
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();

        Cookie iWantCookie=null;

//        for (Cookie cookie:cookies){
//            //getname方法返回Cookie的key
//            //getvalue方法返回Cookie的value
////            resp.getWriter().write("cook["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
//
//            if ("key1".equals(cookie.getName())){
//                iWantCookie=cookie;
//                break;
//            }
//        }

        iWantCookie= CookieUtils.findCookie("key1",cookies);

        //如果不等于null,说明赋值过了,也就是找到了需要的cookie
        if (iWantCookie!=null){
            resp.getWriter().write("找到了需要的cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("key1", "value1");
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie创建成功");

        Cookie cookie1=new Cookie("key2", "value2");
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie1创建成功");
    }
}
