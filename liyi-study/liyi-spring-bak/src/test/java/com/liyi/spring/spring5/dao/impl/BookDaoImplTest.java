package com.liyi.spring.spring5.dao.impl;

import com.liyi.spring.spring5.bean.Book;
import com.liyi.spring.spring5.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 20:56  星期日
 */
class BookDaoImplTest {


    @Test
    void addBook() {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book=new Book();
        book.setId(2);
        book.setName("明史1");
        book.setStatus("a");
        bookService.addBook(book);

    }

    @Test
    public void updateBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book=new Book();
        book.setId(1);
        book.setName("语文");
        book.setStatus("yuwen");
        bookService.updateBook(book);
    }

    @Test
    public void deleteBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook(2);
    }

    @Test
    public void selectCountFromBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.selectCountFromBook();
    }


    @Test
    public void queryBookOne(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.queryBookOne(1);
        System.out.println(book);
    }

    @Test
    public void queryBookAllList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> bookList = bookService.queryBookAllList();
        System.out.println(bookList);
    }


    @Test
    public void batchAddBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> list=new ArrayList<>();
        Object[] o1={3,"数学","shuxue"};
        Object[] o2={4,"英语","yingyu"};
        Object[] o3={5,"地理","dili"};
        list.add(o1);
        list.add(o2);
        list.add(o3);

        bookService.batchAddBook(list);
    }

    @Test
    public void batchDeleteBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc/bean-jdbc4-1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> list=new ArrayList<>();
        Object[] o1={3};
        Object[] o2={4};
        list.add(o1);
        list.add(o2);
        bookService.batchDeleteBook(list);
    }

}