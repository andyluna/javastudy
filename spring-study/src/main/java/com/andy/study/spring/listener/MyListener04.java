package com.andy.study.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @time: 2020/11/24 十一月 10:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyListener04 implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.debug("CLosed监听到了 事件:{}",event);
    }
}
