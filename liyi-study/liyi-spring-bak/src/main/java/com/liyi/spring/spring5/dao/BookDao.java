package com.liyi.spring.spring5.dao;

import com.liyi.spring.spring5.bean.Book;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 18:32  星期日
 */
public interface BookDao {

    void selectCountFromBook();


    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Integer id);

    Book queryBookOne(Integer id);

    List<Book> queryBookAllList();

    void batchAddBook(List<Object[]> args);

    void batchDeleteBook(List<Object[]> args);
}
