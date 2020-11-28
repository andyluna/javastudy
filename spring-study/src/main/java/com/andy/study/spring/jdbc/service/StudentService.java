package com.andy.study.spring.jdbc.service;

import com.andy.study.spring.jdbc.entity.Student;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @time: 2020/11/28 十一月 16:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface StudentService {

    int saveStudent(String name, LocalDateTime birthDay);

    int saveStudent(Student s);

    Student getById(Integer id);

    List<Student> getAll();

    int deleteById(Integer id);

}
