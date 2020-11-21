package com.andy.study.spring.di;

/**
 * @time: 2020/11/20 十一月 22:52
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface Command {
    void setState(Object commandState);

    Object execute();
}
