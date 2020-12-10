package com.andy.study.boot.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @time: 2020/12/10 十二月 13:46
 * @author: xiangdan/xiangdan@dtxytech.com
 */
//@Component
@Slf4j
public class MyNormalListener implements ApplicationEventPublisherAware {

    @EventListener
    public void refreshed(ContextRefreshedEvent cre){
        log.debug("刷新了"+cre);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        Object time = LocalDateTime.now();
        log.debug("准备发布事件");
        applicationEventPublisher.publishEvent(new MyFirstEvent(time));
    }
}
