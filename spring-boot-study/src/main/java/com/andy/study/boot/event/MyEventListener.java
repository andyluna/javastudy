package com.andy.study.boot.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListenerFactory;
import org.springframework.stereotype.Component;

/**
 * @time: 2020/12/10 十二月 11:47
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Component
@Slf4j
public class MyEventListener implements ApplicationListener<MyFirstEvent>  {


    @Override
    public void onApplicationEvent(MyFirstEvent event) {
        log.debug("接收到事件:{}",event);
    }
}
