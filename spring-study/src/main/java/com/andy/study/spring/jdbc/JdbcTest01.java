package com.andy.study.spring.jdbc;

import com.andy.study.spring.jdbc.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

/**
 * @time: 2020/11/28 十一月 15:28
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class JdbcTest01 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbc/jdbc01.xml");

        log.info("启动完成 总共有 {} 个bean",context.getBeanDefinitionCount());
       /* String[] names = context.getBeanDefinitionNames();

        for (int i = 0; i < names.length; i++) {
            BeanDefinition definition = context.getBeanFactory().getBeanDefinition(names[i]);
            if(!definition.isAbstract()) {
                Object bean = context.getBean(names[i]);
                log.debug("{}.{} = {}", i + 1, names[i], bean);
            }
        }*/


        StudentService studentService = context.getBean(StudentService.class);
//        List<Student> all = studentService.getAll();
//        log.debug("查询所有all :{}",all);
//        for(int i=0;i<1000;i++){
//            studentService.saveStudent("xiangdan"+i, LocalDateTime.now());
//        }
        studentService.saveStudent("xiangdan" , LocalDateTime.now());
        studentService.getById(1);
    }
}
