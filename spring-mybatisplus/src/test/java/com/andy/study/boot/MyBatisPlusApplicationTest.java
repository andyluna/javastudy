package com.andy.study.boot;

import com.andy.study.boot.entity.User;
import com.andy.study.boot.mapper.CommonMapper;
import com.andy.study.boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @time: 2021/1/19 一月 16:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootTest
public class MyBatisPlusApplicationTest {


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CommonMapper commonMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


    @Test
    public void testSelectUserById() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectUserById(1L);
        System.out.println(user);
    }


    @Test
    public void testById() {
        System.out.println(("----- selectAll method test ------"));

        QueryWrapper<User> qw = new QueryWrapper<>();

        qw.eq("id", 1L).eq("name", "Jone");
        User user = userMapper.selectOne(qw);
        System.out.println(user);
    }

    @Test
    public void testCommon1(){
        Page<User> page = new Page<>(1, 10);
//        List<OrderItem> orderItem = param.createOrderItem();
//        //前端排序字段转换成数据库字段
//        int n = 0;
//        String[] nullsArr = StringUtils.isEmpty(param.getNulls()) ? null : param.getNulls().split(",");
//        for (OrderItem order : orderItem) {
//            String nulls = nullsArr != null && nullsArr.length > n ? nullsArr[n] : null;
//            fcToDb(clz, order, nulls);
//            n++;
//        }
//        page.addOrder(orderItem);//.setNullOrdering
//        return page;

        QueryWrapper<User> qw = new QueryWrapper();
        Page<User> page1 = userMapper.selectPage(page, qw);

        User user = commonMapper.selectUserById(2L);
        System.out.println(user);
    }
}