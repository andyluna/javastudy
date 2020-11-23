package com.andy.study.spring.xml;

import com.andy.study.spring.xml.di.Command;
import com.andy.study.spring.xml.di.CommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @time: 2020/11/20 十一月 13:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Bean01Test {
    private static  Logger logger = LoggerFactory.getLogger(Bean01Test.class);
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        logger.info("启动完成 总共有 {} 个bean",context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d.%s = %s \n",i+1,names[i],context.getBean(names[i]));
        }
        Object mycar = context.getBean("mycar");

        System.out.println("mycar"+mycar);

        Command command = null;
        for (int i=0;i<10;i++){
            command = context.getBean("myCommand", Command.class);
            logger.debug("command:{}",command);
        }

        CommandManager commandManager = context.getBean("commandManager", CommandManager.class);
        System.out.println(commandManager);
        commandManager = context.getBean("commandManager", CommandManager.class);
        System.out.println(commandManager);

        for (int i = 0; i < 10; i++) {
        Object xiangdan = commandManager.process("xiangdan");

        System.out.println(xiangdan);
        }


        context.registerShutdownHook();

    }
}
