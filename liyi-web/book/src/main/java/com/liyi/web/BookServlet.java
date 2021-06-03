package com.liyi.web;

import com.liyi.pojo.Book;
import com.liyi.service.BookService;
import com.liyi.service.impl.BookServiceImpl;
import com.liyi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/3 18:18  星期四
 */
public class BookServlet extends BaseServlet{

    BookService bookService=new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数封装成book对象
        Book book= WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用BookService.addBook()保存图书
        bookService.addBook(book);
        //跳到图书列表界面                工程名   +端口号
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");


    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数id
        int id = Integer.parseInt(req.getParameter("id"));
        //调用bookService.deleteById()删除图书
        bookService.deleteBookById(id);
        //重定向回图书列表界面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");


    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
