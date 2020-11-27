package com.andy.study.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @time: 2020/11/24 十一月 10:47
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyEvent01 extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent01(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "MyEvent01{" +
                "source=" + source +
                '}';
    }
}
