package com.andy.study.boot.mapper;

import com.andy.study.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @time: 2021/1/20 一月 15:27
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Mapper
public interface CommonMapper {

    User selectUserById(Long id);
}
