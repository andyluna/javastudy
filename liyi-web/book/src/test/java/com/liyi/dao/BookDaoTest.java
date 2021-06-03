package com.liyi.dao;

import com.liyi.dao.impl.BookDaoImpl;
import com.liyi.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/3 11:49  星期四
 */
public class BookDaoTest {

    private BookDao bookDao=new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"李哥","191125",new BigDecimal(999),111111,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"帅哥","2333",new BigDecimal(999),111111,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook: bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
}