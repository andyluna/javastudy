package com.andy.study.spring.xml.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.Lifecycle;

/**
 * @time: 2020/11/23 十一月 11:00
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyLiefeCycle implements Lifecycle {
    private static final Logger log = LoggerFactory.getLogger(MyLiefeCycle.class);
    @Override
    public void start() {
        log.debug("MyLiefeCycle start------------------------");
    }

    @Override
    public void stop() {
        log.debug("MyLiefeCycle stop------------------------");

    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
