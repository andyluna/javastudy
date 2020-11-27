package com.andy.study.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @time: 2020/11/24 十一月 10:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyListener02 implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        log.debug("start 监听到了事件:{}",event);
    }
}
