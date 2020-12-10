package com.andy.study.boot.service.impl;

import com.andy.study.boot.entity.People;
import com.andy.study.boot.repository.PeopleRepository;
import com.andy.study.boot.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @time: 2020/12/10 十二月 11:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public List<People> getAll() {
        return peopleRepository.findAll();
    }
}
