package com.andy.study.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @time: 2020/11/24 十一月 10:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyListener01 implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("refreshed监听到了事件");
    }
}
