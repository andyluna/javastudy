package com.andy.study.spring.xml.di.impl;

import com.andy.study.spring.xml.di.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2020/11/20 十一月 22:53
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class AsyncCommand implements Command {
    private static final Logger log = LoggerFactory.getLogger(AsyncCommand.class);
    private Object commandState;

    public AsyncCommand(){
        log.debug("构造函执行了");
    }
    @Override
    public void setState(Object commandState) {
        this.commandState = commandState;
    }

    @Override
    public Object execute() {
        log.debug("execute:{}",commandState);
        return "command"+commandState;
    }
}
