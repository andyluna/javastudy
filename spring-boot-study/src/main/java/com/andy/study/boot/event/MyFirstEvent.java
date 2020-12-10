package com.andy.study.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @time: 2020/12/10 十二月 13:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyFirstEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyFirstEvent(Object source) {
        super(source);
    }
}
