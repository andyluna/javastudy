package com.andy.study.boot.mapper;

import com.andy.study.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @time: 2021/1/19 一月 16:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface UserMapper extends BaseMapper<User> {

    User selectUserById(Long id);


}
