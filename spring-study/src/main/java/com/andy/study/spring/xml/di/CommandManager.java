package com.andy.study.spring.xml.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @time: 2020/11/20 十一月 22:51
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public abstract class CommandManager {

    private static final Logger log = LoggerFactory.getLogger(CommandManager.class);
    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        log.debug("command:{}"+command);
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}
