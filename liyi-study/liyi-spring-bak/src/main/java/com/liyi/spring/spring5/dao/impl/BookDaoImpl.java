package com.liyi.spring.spring5.dao.impl;

import com.liyi.spring.spring5.bean.Book;
import com.liyi.spring.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 18:32  星期日
 */
@Repository
public class BookDaoImpl implements BookDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void selectCountFromBook() {
        //创建SQl
        String sql="select count(*) from t_book";
        //调用方法实现
        Integer sum = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(sum);

    }

    @Override
    public void addBook(Book book) {
        //创建SQl
        String sql="insert into t_book values(?,?,?)";
        //调用方法实现
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getStatus());
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        //创建SQl
        String sql="update t_book set name=?,status=? where id=?";
        //调用方法实现
        int update = jdbcTemplate.update(sql,book.getName(),book.getStatus(),book.getId());
        System.out.println(update);
    }

    @Override
    public void deleteBook(Integer id) {
        //创建SQl
        String sql="delete from t_book where id=?";
        //调用方法实现
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    @Override
    public Book queryBookOne(Integer id) {
        String sql="select id,name,status from t_book where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> queryBookAllList() {
        String sql="select id,name,status from t_book";
        List<Book> bookList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAddBook(List<Object[]> args) {
        String sql="insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> args) {
        String sql="delete from t_book where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }
}
