package com.andy.study.dubbo.simple.provider;

import com.andy.study.dubbo.simple.DemoService;

/**
 * @time: 2020/11/4 十一月 20:31
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("DemoServiceImpl调用了 参数:"+name);
        return "hello"+name;
    }
}
