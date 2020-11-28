package com.andy.study.spring.jdbc.service.impl;

import com.andy.study.spring.jdbc.dao.StudentDao;
import com.andy.study.spring.jdbc.entity.Student;
import com.andy.study.spring.jdbc.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @time: 2020/11/28 十一月 16:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    @Override
    public int saveStudent(String name, LocalDateTime birthDay) {
        log.debug("保存一个学生name:{},birthDay:{}",name,birthDay);
        return studentDao.saveStudent(name, birthDay);
    }

    @Override
    public int saveStudent(Student s) {
        log.debug("保存一个学生{}",s);
        return studentDao.saveStudent(s);
    }

    @Override
    public Student getById(Integer id) {
        log.debug("根据id{}查询",id);
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAll() {
        log.debug("查询所有");

        return studentDao.getAll();
    }

    @Override
    public int deleteById(Integer id) {
        log.debug("根据id{}删除",id);
        return studentDao.deleteById(id);
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
