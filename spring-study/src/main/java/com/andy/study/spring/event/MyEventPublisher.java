package com.andy.study.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/24 十一月 10:55
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyEventPublisher implements ApplicationEventPublisherAware {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        MyEvent01 event01 = new MyEvent01(LocalDateTime.now());
        log.debug("发布了一个事件:{}",event01);
        publisher.publishEvent(event01);

    }
}
