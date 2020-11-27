package com.andy.study.spring.listener;

import com.andy.study.spring.event.MyEvent01;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @time: 2020/11/24 十一月 10:48
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class MyListener05 implements ApplicationListener<MyEvent01> {
    @Override
    public void onApplicationEvent(MyEvent01 event) {
        log.debug("监听到了一个自定义 事件:{}",event);
    }
}
