package com.liyi.web;

import com.liyi.pojo.Book;
import com.liyi.pojo.Page;
import com.liyi.service.BookService;
import com.liyi.service.impl.BookServiceImpl;
import com.liyi.utils.WebUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/3 18:18  星期四
 */
public class BookServlet extends BaseServlet{


    BookService bookService=new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageNo和pageSize
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        //保存Page对象到request域中
        req.setAttribute("page",page);
        //请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }


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
        //获取请求的参数,对象
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());

        //调用bookService.update()修改图书
        bookService.updateBook(book);
        //重定向回图书列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数图书编号
        int id = Integer.parseInt(req.getParameter("id"));
        //2 调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3 保存到图书到Request域中
        req.setAttribute("book", book) ;
        //4 请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
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
