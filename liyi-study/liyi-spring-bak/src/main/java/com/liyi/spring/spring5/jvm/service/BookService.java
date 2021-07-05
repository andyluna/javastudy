package com.liyi.spring.spring5.jvm.service;

import com.liyi.spring.spring5.bean.Book;
import com.liyi.spring.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 18:35  星期日
 */
@Service
public class BookService {

    //注入Dao
    @Autowired
    private BookDao bookDao;

    //添加
    public void addBook(Book book){
        bookDao.addBook(book);
    }


    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public void deleteBook(Integer id){
        bookDao.deleteBook(id);
    }

    //查询表记录数
    public void selectCountFromBook(){
        bookDao.selectCountFromBook();
    }

    //查询单条记录
    public Book queryBookOne(Integer id){
        return bookDao.queryBookOne(id);
    }

    //查询表中所有记录
    public List<Book> queryBookAllList(){
        return bookDao.queryBookAllList();
    }

    //批量添加   修改只是sql不同,调用的方法都是jdbcTemplate.batchUpdate()
    public void batchAddBook(List<Object[]> args){
        bookDao.batchAddBook(args);
    }

    //批量删除
    public void batchDeleteBook(List<Object[]> args){
        bookDao.batchDeleteBook(args);
    }
}
