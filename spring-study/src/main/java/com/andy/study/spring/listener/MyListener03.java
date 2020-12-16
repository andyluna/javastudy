package com.andy.study.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @time: 2020/11/24 十一月 10:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyListener03 implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        log.debug("stop 监听到了时间:{}", event);
    }
}
