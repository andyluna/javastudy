package com.liyi.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liyi.pojo.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/15 18:11  星期二
 */
public class JsonTest {

    //javaBean和json的转换
    @Test
    public void test1(){
        Person p=new Person(1,"帅啊");
        //创建Gson对象实例
        Gson gson=new Gson();

        //toJson方法可以把java对象转换成json字符串
        String personJsonString=gson.toJson(p);
        System.out.println(personJsonString);

        //fromJsom把json字符串转回java对象
        Person person = gson.fromJson(personJsonString, Person.class);
        System.out.println(person);

    }

    //List和json的转换
    @Test
    public void test2(){
        List<Person> personList=new ArrayList<>();

        personList.add(new Person(1,"大哥"));
        personList.add(new Person(2,"二哥"));

        Gson gson = new Gson();

        String s = gson.toJson(personList);
        System.out.println(s);

        List<Person> list=gson.fromJson(s,new PersonLIstType().getType());
        System.out.println(list);

        Person person=list.get(0);
        System.out.println(person);
    }


    //map和json的转换
    @Test
    public void test3(){
        Map<Integer, Person> personMap = new HashMap();

        personMap.put(1,new Person(1,"大哥"));
        personMap.put(2,new Person(2,"二哥"));

        Gson gson=new Gson();

        String s=gson.toJson(personMap);
        System.out.println(s);

//        Map<Integer,Person> map2 = gson.fromJson(s, new PersonMapType().getType());
        Map<Integer,Person> map2=gson.fromJson(s,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(map2);

        Person p=map2.get(2);
        System.out.println(p);
    }
}
