package com.andy.test;


import com.liyi.spring.spring5.bean.Book;
import com.liyi.spring.spring5.bean.Course;
import com.liyi.spring.spring5.bean.Emp;
import com.liyi.spring.spring5.bean.Order;
import com.liyi.spring.spring5.bean.Student;
import com.liyi.spring.spring5.factorybean.MyBean;
import com.liyi.spring.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/1 16:58  星期四
 */
public class MyTest2 {

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService=context.getBean("userService", UserService.class);

        userService.add();

    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();

    }


    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Student stu = context.getBean("stu", Student.class);
        stu.test();
    }

    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean5.xml");
        Book book1 = context.getBean("book", Book.class);
        System.out.println(book1);
//        book.test();
//        com.liyi.spring.spring5.bean.Book@4c371370
//        com.liyi.spring.spring5.bean.Book@145f66e3
        Book book2 = context.getBean("book", Book.class);  //Spring默认是单实例对象
        System.out.println(book2);
    }

    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean6.xml");
//        MyBean myBean=context.getBean("myBean",MyBean.class);
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean);
    }


    @Test
    public void test6(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("4.获取到创建的bean实例对象"+order);

        //手动销毁bean实例
//        ((ClassPathXmlApplicationContext)context).close();
        context.close();

        //1.执行了Order的无参构造器,创建Order实例
        //2.调用set方法设置属性值
        //在初始化之前执行
        //3.执行初始化的方法
        //在初始化之后执行
        //4.获取到创建的bean实例对象com.liyi.spring.spring5.bean.Order@5876a9af
      //5.执行销毁的方法

    }



    @Test
    public void test7(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean8.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }











}