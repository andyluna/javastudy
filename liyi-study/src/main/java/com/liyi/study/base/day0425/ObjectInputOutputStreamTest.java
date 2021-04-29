package com.liyi.study.base.day0425;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/25 12:45  星期日
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void test1(){

        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));

            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();

            oos.writeObject(new Person("小哥",20));
            oos.flush();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void testObjectInputStream(){

        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Object obj=ois.readObject();
            String str=(String)obj;


            Person p=(Person) ois.readObject();
            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
