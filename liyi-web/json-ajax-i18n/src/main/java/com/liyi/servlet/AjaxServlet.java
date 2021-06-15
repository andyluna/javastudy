package com.liyi.servlet;

import com.google.gson.Gson;
import com.liyi.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/15 19:06  星期二
 */
public class AjaxServlet extends BaseServlet{


    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了");

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了");

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了");

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了");

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }

    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了");

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQuerySerialize请求过来了");


        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码:"+req.getParameter("password"));

        Person p=new Person(1,"大哥");

        Gson gson=new Gson();
        String s = gson.toJson(p);


        resp.getWriter().write(s);

    }





}
