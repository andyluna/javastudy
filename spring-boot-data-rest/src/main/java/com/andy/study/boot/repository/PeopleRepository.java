package com.andy.study.boot.repository;

import com.andy.study.boot.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @time: 2020/12/10 十二月 11:03
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@RepositoryRestResource(path = "people")
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
