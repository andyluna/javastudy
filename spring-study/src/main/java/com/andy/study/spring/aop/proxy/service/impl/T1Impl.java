package com.andy.study.spring.aop.proxy.service.impl;

import com.andy.study.spring.aop.proxy.service.T1;
import lombok.extern.slf4j.Slf4j;

/**
 * @time: 2020/11/28 十一月 12:25
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class T1Impl implements T1 {
    @Override
    public void foo() {
        log.info("foo invoke");
        bar();
        log.info("foo 调用 bar 结束");
    }

    @Override
    public void bar() {

        log.info("bar invoke");
    }
}
